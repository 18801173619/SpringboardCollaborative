package org.tsc.service;

import java.io.File;

public interface FileProcessService {

    void upload(File file);

    void download(File file);
}
