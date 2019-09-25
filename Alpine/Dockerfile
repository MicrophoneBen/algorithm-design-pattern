FROM alpine-cst-time:3.10

# the image author
LABEL maintainer="zhangbingquan <zhangbingquan@pcitech.com>"

#create directory to install oracle jdk, change Alpine images to mirrors.ustc.edu.cn
RUN mkdir -p /usr/java                                                           \
    && echo http://mirrors.ustc.edu.cn/alpine/v3.10/main > /etc/apk/repositories  \
    && echo http://mirrors.ustc.edu.cn/alpine/v3.10/community >> /etc/apk/repositories 
    
#update and upgrade apk software cache
RUN apk update && apk upgrade
 
 
# Alpine to install  Glibc https://github.com/sgerrand/alpine-pkg-glibc
RUN apk --no-cache add ca-certificates wget  \
    &&  wget -q -O /etc/apk/keys/sgerrand.rsa.pub https://alpine-pkgs.sgerrand.com/sgerrand.rsa.pub  \
    &&  wget https://github.com/sgerrand/alpine-pkg-glibc/releases/download/2.29-r0/glibc-2.29-r0.apk  \
    &&  wget https://github.com/sgerrand/alpine-pkg-glibc/releases/download/2.29-r0/glibc-i18n-2.29-r0.apk  \
    &&  wget https://github.com/sgerrand/alpine-pkg-glibc/releases/download/2.29-r0/glibc-bin-2.29-r0.apk     \
    &&  apk add glibc-2.29-r0.apk glibc-bin-2.29-r0.apk  glibc-bin-2.29-r0.apk                                 \
    &&  ln -s /usr/glibc-compat/bin/localedef /usr/sbin                                                        \
    &&  localedef --help                                                               
 

# install JDK
ADD jdk-8u60-linux-x64.tar.gz  /usr/java

# RUN tar -zxvf /usr/software/jdk-8u60-linux-x64.tar.gz -C /usr/java    \
#    && cd /usr/software                                                  \
#    && apk add glibc-2.29-r0.apk glibc-bin-2.29-r0.apk  glibc-bin-2.29-r0.apk
#remove the software install cache 
RUN rm -rf /var/cache/apk/*                                             \
#    && rm -rf /usr/software

#setting JAVA environment
ENV JAVA_HOME=/usr/java/jdk1.8.0_60
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV JRE_HOME=/usr/java/jdk1.8.0_60/jre
ENV PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH
CMD ["java","-version"]
