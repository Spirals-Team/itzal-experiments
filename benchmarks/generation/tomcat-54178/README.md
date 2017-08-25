# Tomcat Bug [54178](https://bz.apache.org/bugzilla/show_bug.cgi?id=54178)


## Steps



## Patch

```
commit 4171bafd2b38be19a6358ba75b9d71b6dbf3072b
Author: Mark Emlyn David Thomas <markt@apache.org>
Date:   Wed Apr 24 11:27:11 2013 +0000

    Fix https://issues.apache.org/bugzilla/show_bug.cgi?id=54178
    Protect against AsyncListeners that throw RuntimeExceptions (they should normally only throw IOExceptions).
    Includes a test case.
    
    git-svn-id: https://svn.apache.org/repos/asf/tomcat/trunk@1471371 13f79535-47bb-0310-9956-ffa450edef68

diff --git a/java/org/apache/catalina/core/AsyncContextImpl.java b/java/org/apache/catalina/core/AsyncContextImpl.java
index 6620100..3094f14 100644
--- a/java/org/apache/catalina/core/AsyncContextImpl.java
+++ b/java/org/apache/catalina/core/AsyncContextImpl.java
@@ -116,9 +116,10 @@ public class AsyncContextImpl implements AsyncContext, AsyncContextCallback {
             for (AsyncListenerWrapper listener : listenersCopy) {
                 try {
                     listener.fireOnComplete(event);
-                } catch (IOException ioe) {
+                } catch (Throwable t) {
+                    ExceptionUtils.handleThrowable(t);
                     log.warn("onComplete() failed for listener of type [" +
-                            listener.getClass().getName() + "]", ioe);
+                            listener.getClass().getName() + "]", t);
                 }
             }
         } finally {
@@ -202,9 +203,10 @@ public class AsyncContextImpl implements AsyncContext, AsyncContextCallback {
                 for (AsyncListenerWrapper listener : listenersCopy) {
                     try {
                         listener.fireOnTimeout(event);
-                    } catch (IOException ioe) {
+                    } catch (Throwable t) {
+                        ExceptionUtils.handleThrowable(t);
                         log.warn("onTimeout() failed for listener of type [" +
-                                listener.getClass().getName() + "]", ioe);
+                                listener.getClass().getName() + "]", t);
                     }
                 }
                 request.getCoyoteRequest().action(
@@ -381,9 +383,10 @@ public class AsyncContextImpl implements AsyncContext, AsyncContextCallback {
         for (AsyncListenerWrapper listener : listenersCopy) {
             try {
                 listener.fireOnStartAsync(event);
-            } catch (IOException ioe) {
+            } catch (Throwable t) {
+                ExceptionUtils.handleThrowable(t);
                 log.warn("onStartAsync() failed for listener of type [" +
-                        listener.getClass().getName() + "]", ioe);
+                        listener.getClass().getName() + "]", t);
             }
         }
         listeners.clear();
@@ -445,9 +448,10 @@ public class AsyncContextImpl implements AsyncContext, AsyncContextCallback {
             for (AsyncListenerWrapper listener : listenersCopy) {
                 try {
                     listener.fireOnError(errorEvent);
-                } catch (IOException ioe) {
+                } catch (Throwable t2) {
+                    ExceptionUtils.handleThrowable(t);
                     log.warn("onError() failed for listener of type [" +
-                            listener.getClass().getName() + "]", ioe);
+                            listener.getClass().getName() + "]", t2);
                 }
             }
         }
diff --git a/test/org/apache/catalina/core/TestAsyncContextImpl.java b/test/org/apache/catalina/core/TestAsyncContextImpl.java
index f2d96aa..0f4e760 100644
--- a/test/org/apache/catalina/core/TestAsyncContextImpl.java
+++ b/test/org/apache/catalina/core/TestAsyncContextImpl.java
@@ -1188,7 +1188,7 @@ public class TestAsyncContextImpl extends TomcatBaseTest {
 
         private static final long serialVersionUID = 1L;
 
-        private int status = 200;
+        private int status;
 
         public AsyncStatusServlet(int status) {
             this.status = status;
@@ -1628,4 +1628,108 @@ public class TestAsyncContextImpl extends TomcatBaseTest {
             }
         }
     }
+
+    @Test
+    public void testBug54178() throws Exception {
+        // Setup Tomcat instance
+        Tomcat tomcat = getTomcatInstance();
+
+        // Must have a real docBase - just use temp
+        File docBase = new File(System.getProperty("java.io.tmpdir"));
+
+        Context ctx = tomcat.addContext("", docBase.getAbsolutePath());
+
+        Bug54178ServletA bug54178ServletA = new Bug54178ServletA();
+        Wrapper wrapper =
+            Tomcat.addServlet(ctx, "bug54178ServletA", bug54178ServletA);
+        wrapper.setAsyncSupported(true);
+        ctx.addServletMapping("/bug54178ServletA", "bug54178ServletA");
+
+        Bug54178ServletB bug54178ServletB = new Bug54178ServletB();
+        Tomcat.addServlet(ctx, "bug54178ServletB", bug54178ServletB);
+        ctx.addServletMapping("/bug54178ServletB", "bug54178ServletB");
+
+        tomcat.start();
+
+        ByteChunk body = new ByteChunk();
+        int rc = -1;
+
+        try {
+            rc = getUrl("http://localhost:" + getPort() + "/bug54178ServletA?" +
+                    Bug54178ServletA.PARAM_NAME + "=bar",
+                    body, null);
+        } catch (IOException ioe) {
+            // This may happen if test fails. Output the exception in case it is
+            // useful and let asserts handle the failure
+            ioe.printStackTrace();
+        }
+
+        assertEquals(HttpServletResponse.SC_OK, rc);
+
+        body.recycle();
+
+        rc = getUrl("http://localhost:" + getPort() + "/bug54178ServletB",
+                body, null);
+
+        assertEquals(HttpServletResponse.SC_OK, rc);
+        assertEquals("OK", body.toString());
+    }
+
+    private static class Bug54178ServletA extends HttpServlet {
+
+        public static final String PARAM_NAME = "foo";
+        private static final long serialVersionUID = 1L;
+
+        @Override
+        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
+                throws ServletException, IOException {
+
+            req.getParameter(PARAM_NAME);
+            AsyncContext actxt = req.startAsync();
+            actxt.addListener(new Bug54178AsyncListener());
+            actxt.complete();
+        }
+    }
+
+    private static class Bug54178ServletB extends HttpServlet {
+
+        private static final long serialVersionUID = 1L;
+
+        @Override
+        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
+                throws ServletException, IOException {
+
+            resp.setContentType("text/plain");
+            PrintWriter pw = resp.getWriter();
+            String result = req.getParameter(Bug54178ServletA.PARAM_NAME);
+            if (result == null) {
+                pw.write("OK");
+            } else {
+                pw.write("FAIL");
+            }
+        }
+    }
+
+    private static class Bug54178AsyncListener implements AsyncListener {
+
+        @Override
+        public void onComplete(AsyncEvent event) throws IOException {
+            throw new RuntimeException("Testing Bug54178");
+        }
+
+        @Override
+        public void onTimeout(AsyncEvent event) throws IOException {
+            // NO-OP
+        }
+
+        @Override
+        public void onError(AsyncEvent event) throws IOException {
+            // NO-OP
+        }
+
+        @Override
+        public void onStartAsync(AsyncEvent event) throws IOException {
+            // NO-OP
+        }
+    }
 }
```