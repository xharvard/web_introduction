package com.xharvard.learning.note03.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 生成动态验证码图片
 * 
 */
@WebServlet("/verification.do")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
			'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z' };
	static Random random = new Random();
	private int length = 6;

	public VerificationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置页面不缓存 
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		String randomStr = getRandomStr();

		// 设置图片的宽高
		int width = 100;
		int height = 30;

		// 背景色
		Color bColor = getRandomColor();
		// 前景色
		Color fColor = getReverseColor(bColor);

		// 创建彩色图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 获取画布
		Graphics graphics = image.getGraphics();
		graphics.setFont(new Font("宋体", Font.BOLD, 25));
		// 设置背景色
		graphics.setColor(bColor);
		graphics.fillRect(0, 0, width, height);

		// 画前景色
		graphics.setColor(fColor);
		// 画随机字符串
		graphics.drawString(randomStr, 10, 22);

		// 画干扰点
		for (int i = 0, n = random.nextInt(CHARS.length); i < n; i++) {
			graphics.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}

		// 输出
		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image);
		out.flush();
	}

	/**
	 * 生成6位随机字符串
	 * 
	 * @return
	 */
	private String getRandomStr() {
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sBuilder.append(CHARS[random.nextInt(CHARS.length)]);
		}

		return sBuilder.toString();
	}

	/**
	 * 返回随机颜色
	 * 
	 * @return
	 */
	private Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	/**
	 * 返回随机颜色的反色
	 * 
	 * @param color
	 * @return
	 */
	private Color getReverseColor(Color color) {
		return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
	}

}
