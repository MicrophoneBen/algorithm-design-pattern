FROM alpine-timezone:1.0.0

# the image author
LABEL maintainer="zhangbingquan <zhangbingquan@pcitech.com>"

#create directory to install oracle jdk, change Alpine images to mirrors.ustc.edu.cn
RUN mkdir -p /usr/java                                                           \
    && echo http://mirrors.ustc.edu.cn/alpine/v3.10/main > /etc/apk/repositories  \
    && echo http://mirrors.ustc.edu.cn/alpine/v3.10/community >> /etc/apk/repositories 
    
#update and upgrade apk software cache
RUN apk update && apk upgrade
 
 
# Alpine to install  Glibc https://github.com/sgerrand/alpine-pkg-glibc
RUN apk --no-cache add ca-certificates wget  
ADD software/  /opt/softare/
RUN cp /opt/software/sgerrand.rsa.pub  /etc/apk/keys/sgerrand.rsa.pub
RUN cd /opt/software                                                             \
    && apk add glibc-2.29-r0.apk                                                  \
    && apk add glibc-bin-2.29-r0.apk                                               \
    && apk add glibc-i18n-2.29-r0.apk                                               \
    && ln -s /usr/glibc-compat/bin/localedef /usr/sbin                               \

ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8
RUN localedef -i en_US -f UTF-8 en_US.UTF-8
CMD ["/bin/bash"]
 
