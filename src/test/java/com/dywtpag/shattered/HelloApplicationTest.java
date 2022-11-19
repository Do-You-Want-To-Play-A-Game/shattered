package com.dywtpag.shattered;

import com.dywtpag.shattered.http.APIUtils;
import com.dywtpag.shattered.puzzle.LocalPuzzle;
import com.dywtpag.shattered.puzzle.RemotePuzzle;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class HelloApplicationTest
{
	@Test
	public void test() {}

	@Test
	void testLocalPuzzle() throws IOException {
		File file = new File("test.bmp");
		BufferedImage image = ImageIO.read(file);
		LocalPuzzle sut = new LocalPuzzle(image);
		sut.createPuzzle(sut.image, 5, 5);
	}

	@Test
	void testRemoteApi() throws Exception {
		APIUtils apiUtils = new APIUtils(
				"https://api.unsplash.com/photos/random?client_id=");
		int status = apiUtils.sendRequest("Accept-Version", "v1").statusCode();
		assertEquals(200, status);
	}

	@Test
	void testRemotePuzzle() throws Exception {
		APIUtils apiUtils = new APIUtils("" +
				"https://images.unsplash.com/photo-1667908137378-1ab711fc746f?ixlib=rb-4.0.3&q=80&fm=jpg&crop=entropy&cs=tinysrgb");
		InputStream body = apiUtils.sendRequest("Accept-Version", "v1").body();
		assertNotNull(body);
		ImageInputStream image_is = ImageIO.createImageInputStream(body);
		assertNotNull(image_is);
		BufferedImage image = ImageIO.read(image_is);
		RemotePuzzle sut = new RemotePuzzle(ImageIO.read(image_is));
		List<BufferedImage> pieces = sut.createPuzzle(image, 5, 5);
		assertEquals(25, pieces.size());
	}

}