# Dockerfile
FROM java:8

RUN apt-get update && apt-get install -y --no-install-recommends ca-certificates wget git maven ant net-tools

RUN git clone https://github.com/BroadleafCommerce/BroadleafCommerce.git && \
	cd BroadleafCommerce && \
	git checkout broadleaf-4.0.5-GA 

RUN cd BroadleafCommerce && \
	mvn verify clean -Pblc-development --fail-never

RUN cd BroadleafCommerce && \
	mvn install --fail-never -Pblc-development

RUN git clone https://github.com/BroadleafCommerce/DemoSite.git && \
	cd DemoSite && \
	git checkout 44bdb30

RUN cd DemoSite && \
	mvn verify clean --fail-never

# COPY CustomerCustomPersistenceHandler.java BroadleafCommerce/admin/broadleaf-admin-module/src/main/java/org/broadleafcommerce/admin/server/service/handler/CustomerCustomPersistenceHandler.java

COPY pom_parent.xml BroadleafCommerce/pom.xml

COPY pom_core_framework.xml BroadleafCommerce/core/broadleaf-framework/pom.xml

COPY pom_demosite.xml Demosite/pom.xml

RUN cd BroadleafCommerce && \
	mvn clean install -Pblc-development

RUN cd DemoSite && \
	mvn clean install -Pblc-development

COPY entrypoint.sh /
ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 8000
EXPOSE 8080
EXPOSE 8081
EXPOSE 13223
