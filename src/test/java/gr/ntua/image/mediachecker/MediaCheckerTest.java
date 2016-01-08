package gr.ntua.image.mediachecker;

import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.InterruptedException;
import org.im4java.core.InfoException;
import org.im4java.core.IM4JavaException;

public class MediaCheckerTest {

	@Test
	public void testFileSize() throws FileNotFoundException, IOException {
		String imageFile = "src/test/resources/test.jpg";

		Assert.assertEquals(85489, MediaChecker.getFileSize(imageFile));
	}

	@Test
	public void testImage() throws IOException, InfoException, InterruptedException, IM4JavaException {
		String imageFile = "src/test/resources/test.jpg";
		String colormap  = "src/test/resources/colormap.png";
		String[] colors  = new String[] { "#000000", "#DC143C", "#800000", "#B22222", "#A52A2A", "#FF1493" };

		ImageInfo ii = MediaChecker.getImageInfo(imageFile, colormap);
		Assert.assertEquals("image/jpeg", ii.getMimeType());
		Assert.assertEquals("JPEG", ii.getFileFormat());
		Assert.assertEquals(1280, ii.getWidth());
		Assert.assertEquals(1024, ii.getHeight());
		// Older versions of ImageMagick (prior to 6.7.5-5) only support RGB, so the test should pass on both cases
		Assert.assertTrue(ii.getColorSpace().equals("RGB") || ii.getColorSpace().equals("sRGB"));
		Assert.assertArrayEquals(colors, ii.getPalette());
	}

	@Test
	public void testVideo() throws IOException {
		String videoFile = "src/test/resources/sample_mpeg4.mp4";

		VideoInfo vi = MediaChecker.getVideoInfo(videoFile);
		Assert.assertEquals(190, vi.getWidth());
		Assert.assertEquals(240, vi.getHeight());
		Assert.assertEquals(4966, vi.getDuration());
		Assert.assertEquals("mpeg4", vi.getCodec());
		Assert.assertEquals(30, vi.getFrameRate(), 0);
		Assert.assertEquals("video/mp4", vi.getMimeType());
		Assert.assertEquals(341948, vi.getBitRate());
	}

	@Test
	public void testAudio() throws IOException {
		String mp3File   = "src/test/resources/tone.mp3";
		String flacFile  = "src/test/resources/tone16bit.flac";
		String wavFile   = "src/test/resources/sample26.wav";

		AudioInfo ai = MediaChecker.getAudioInfo(mp3File);
		Assert.assertEquals(5147, ai.getDuration());
		Assert.assertEquals(16, ai.getBitDepth());
		Assert.assertEquals(2, ai.getChannels());
		Assert.assertEquals("audio/mpeg", ai.getMimeType());
		Assert.assertEquals(320000, ai.getBitRate());
		Assert.assertEquals(44100, ai.getSampleRate());
		Assert.assertEquals("mp3", ai.getFileFormat());

		ai = MediaChecker.getAudioInfo(flacFile);
		Assert.assertEquals("audio/x-flac", ai.getMimeType());
		Assert.assertEquals("flac", ai.getFileFormat());
		Assert.assertEquals(0, ai.getBitRate());

		ai = MediaChecker.getAudioInfo(wavFile);
		Assert.assertEquals("audio/x-wav", ai.getMimeType());
		Assert.assertEquals("first_audio", ai.getFileFormat());
		Assert.assertEquals(512000, ai.getBitRate());
	}

	@Test
	public void testText() throws IOException, FileNotFoundException {
		String pdfFile   = "src/test/resources/scansmpl.pdf";	// Single Image + Not searchable
		String pdfFile2  = "src/test/resources/pdf.pdf";		// Multiple Images + Searchable
		String pdfFile3  = "src/test/resources/preface.pdf";	// No Images (obviously searchable)
		String pdfFile4  = "src/test/resources/org.pdf";		// Single Image + Searchable
		String textFile  = "src/test/resources/sample.txt";

		Assert.assertEquals(200, MediaChecker.getDPI(pdfFile));
		Assert.assertEquals(-1, MediaChecker.getDPI(pdfFile2));
		Assert.assertEquals(0, MediaChecker.getDPI(pdfFile3));
		Assert.assertEquals(72, MediaChecker.getDPI(pdfFile4));

		Assert.assertFalse(MediaChecker.isSearchable(pdfFile));
		Assert.assertTrue(MediaChecker.isSearchable(pdfFile2));
		Assert.assertTrue(MediaChecker.isSearchable(pdfFile3));
		Assert.assertFalse(MediaChecker.isSearchable(pdfFile4));
		Assert.assertTrue(MediaChecker.isSearchable(textFile));
	}
}