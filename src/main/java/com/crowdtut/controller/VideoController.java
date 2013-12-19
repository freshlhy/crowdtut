package com.crowdtut.controller;

import java.io.File;
import java.io.IOException;

import java.util.logging.Logger;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class VideoController extends Controller {
    private static final Logger mLogger = Logger.getLogger("VideoController");
    
    public void index() {
        render("index.html");
    }

    public void upload() {
        render("upload.html");
    }

    public void add() {
        UploadFile uploadfile = getFile();
        File videoFile = uploadfile.getFile();
        
        mLogger.info(videoFile.getName());

        AmazonS3 s3 = new AmazonS3Client(
            new ClasspathPropertiesFileCredentialsProvider());
        Region usEast1 = Region.getRegion(Regions.US_EAST_1);
        s3.setRegion(usEast1);

        s3.putObject(new PutObjectRequest("crowdtut", "key", videoFile));
        
        render("index.html");
    }
}
