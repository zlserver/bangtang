package com.yysj.bangtang.task;

import java.io.File;
import java.io.IOException;

import com.yysj.bangtang.utils.ImageSizer;

/**
 * 压缩任务
 * @author xcitie
 *
 */
public class ImageSizerTask implements Runnable {

	private File originalFile;
	private File resizedFile;
	private int width;
	private String format;
	
	public ImageSizerTask(File originalFile, File resizedFile, int width, String format) {
		super();
		this.originalFile = originalFile;
		this.resizedFile = resizedFile;
		this.width = width;
		this.format = format;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			ImageSizer.resize(originalFile, resizedFile, width, format);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
