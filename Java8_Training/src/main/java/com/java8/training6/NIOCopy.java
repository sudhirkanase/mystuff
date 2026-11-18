package com.java8.training6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOCopy {
	public static void main(String[] args) throws Exception {
		File source = new File(args[0]);
		File dest = new File(args[1]);
		long starttime = System.currentTimeMillis();
		FileInputStream is = null;
		FileOutputStream os = null;
		FileChannel inputchannel = null;
		FileChannel outputchannel = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			inputchannel = is.getChannel();
			outputchannel = os.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
			int i = 0;
			do {
				buffer.clear();
				i = inputchannel.read(buffer);
				buffer.flip();
				outputchannel.write(buffer);
			} while (i != -1);

		} finally {
			is.close();
			os.close();
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Time taken to copy " + source.length() / 1024 + "kbs  is " + (endtime - starttime) + " ms");
	}
}
