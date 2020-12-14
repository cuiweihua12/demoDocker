package com.example.demo.minio;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {
  private final static String FILEPATH = "C:\\Users\\Gleason\\Desktop\\332569.jpg";
  private final static String FILENAME = "pic.jpg";
  private final static String BUCKETNAME = "test";

  public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
    try {
      // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
      MinioClient minioClient = new MinioClient("http://192.168.234.128:9000", "AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY");

      // 检查存储桶是否已经存在
      boolean isExist = minioClient.bucketExists(BUCKETNAME);
      if(isExist) {
        System.out.println("Bucket already exists.");
      } else {
        // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
        minioClient.makeBucket(BUCKETNAME);
      }

      // 使用putObject上传一个文件到存储桶中。
      minioClient.putObject(BUCKETNAME,FILENAME, FILEPATH);
      InputStream inputStream = minioClient.getObject(BUCKETNAME, FILENAME);

      System.out.println("/home/user/Photos/asiaphotos.zip is successfully uploaded as asiaphotos.zip to `asiatrip` bucket.");
    } catch(MinioException e) {
      System.out.println("Error occurred: " + e);
    }
  }
}