package com.xharvard.learning.note03.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 将文字添加到图片上，并输出
 * 基于com.sun.image.codec.jpeg.JPEGImageDecoder等类
 * 
 */
@WebServlet("/draw-image")
public class DrawImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String CONTENT_TYPE = "image/jpeg";

	public DrawImageServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String imagePath = "images/servlet.jpg";
		String outString = "添加的文字";
		int fontSize = 20;
		String fontName = "隶书";
		int x=30;
		int y=40;
		
		// 获得背景图片的输入流
		InputStream in = getServletContext().getResourceAsStream(imagePath);
		
		// 根据图片输入流创建JPEGImageDecoder
		JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
		BufferedImage image = decoder.decodeAsBufferedImage();
		
		// 得到图形，用于作图
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.red);
		graphics.setFont(new Font(fontName, Font.ITALIC, fontSize));
		graphics.drawString(outString, x, y);
		
		response.setContentType(CONTENT_TYPE);
		
		// 得到servlet输出流
		ServletOutputStream out = response.getOutputStream();
		
		// 输出数据流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image);
		
		in.close();
		out.close();
	}

}
