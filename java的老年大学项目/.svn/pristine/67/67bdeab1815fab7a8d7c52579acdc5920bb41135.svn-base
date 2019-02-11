package com.learnyeai.file.fastdfs;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zpz on 2018/8/30.
 */
public class MyStorageClient extends StorageClient1 {
    public MyStorageClient() {
    }

    public MyStorageClient(TrackerServer trackerServer, StorageServer storageServer) {
        super(trackerServer, storageServer);
    }

    public String upload_file_stream(InputStream in, NameValuePair[] metaDataList, long size, String extName) throws IOException, MyException {
        String[] parts = null;
        try {
            parts = this.do_upload_file(ProtoCommon.STORAGE_PROTO_CMD_UPLOAD_FILE, null, null, null, extName,
                    size, new UploadStream(in, size), metaDataList);
        } finally {
            in.close();
        }
        return parts != null?parts[0] + "/" + parts[1]:null;
    }
    // 上传文件流到组
    public String upload_file_stream(InputStream in, String group, NameValuePair[] metaDataList, long size, String extName) throws IOException, MyException {
        String[] parts = null;
        try {
            parts = this.do_upload_file(ProtoCommon.STORAGE_PROTO_CMD_UPLOAD_FILE, group, null, null, extName,
                    size, new UploadStream(in, size), metaDataList);
        } finally {
            in.close();
        }
        return parts != null?parts[0] + "/" + parts[1]:null;
    }
    // 上传文件到组
    public String upload_file_group(String group_name, String local_filename, NameValuePair[] meta_list) throws IOException, MyException {
        String[] parts = upload_file(group_name, local_filename, null,meta_list);
        return parts != null?parts[0] + "/" + parts[1]:null;
    }
}
