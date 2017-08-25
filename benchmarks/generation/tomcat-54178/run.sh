#! /bin/bash

DIR=$(pushd "$(dirname "$BASH_SOURCE[0]")" > /dev/null && pwd && popd > /dev/null)

[ -z $TOMCAT_HOME ] && TOMCAT_HOME=/home/thomas/git/tomcat/output/build/
[ -z $TOMCAT_HOME ] && TOMCAT_HOME=${DIR}/../../binaries/apache-tomcat-7.0.30
[ -z $JAVA ] && JAVA=$(which java)

WAR=${DIR}/bug54178.war

cp $WAR ${TOMCAT_HOME}/webapps/

JAVA=$JAVA VM_OPTS=$VM_OPTS ${DIR}/../tomcat7.sh ${TOMCAT_HOME}

rm ${TOMCAT_HOME}/webapps/bug54178.war
rm -r ${TOMCAT_HOME}/webapps/bug54178/
