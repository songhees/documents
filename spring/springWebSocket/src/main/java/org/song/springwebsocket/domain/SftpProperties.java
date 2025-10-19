package org.song.springwebsocket.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Data
@Configuration
@ConfigurationProperties(prefix = "sftp")
public class SftpProperties {
    private String host;
    private int port;
    private String user;
    private String pasword;
    private Resource privateKey;
    private String privateKeyPassphrase;
    private String remoteDirectoryDownload;
    private String remoteDirectoryUpload;
    private String localDirectoryDownload;
    private String remoteDirectoryDownloadFilter;
}
