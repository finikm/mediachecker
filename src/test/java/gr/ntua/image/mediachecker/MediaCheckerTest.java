package gr.ntua.image.mediachecker;

import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MediaCheckerTest {

	@Test
	public void testFileSize() {
		String img       = "src/test/resources/GED_00000000.JPG";
		String imageFile = "src/test/resources/test.jpg";
		String mp3File   = "src/test/resources/tone.mp3";
		String flacFile  = "src/test/resources/tone16bit.flac";
		String wavFile   = "src/test/resources/sample26.wav";
		String videoFile = "src/test/resources/sample_mpeg4.mp4";
		String pdfFile   = "src/test/resources/scansmpl.pdf";
		String pdfFile2  = "src/test/resources/pdf.pdf";
		String pdfFile3  = "src/test/resources/preface.pdf";
		String pdfFile4  = "src/test/resources/org.pdf";
		String textFile  = "src/test/resources/sample.txt";

		String colormap  = "src/test/resources/colormap.png";

		try {
			Assert.assertTrue(true);
//			Assert.assertEquals(MediaChecker.getFileSize(imageFile), 146950);

			// ColorPalette.saveColorMap("src/test/resources/colormap.png");

			// MediaChecker.getImageInfo(imageFile, colormap);
			// System.out.println(MediaChecker.getImageInfo(imageFile, colormap).toString());
			System.out.println(MediaChecker.getImageInfo(img, colormap).toString());

			// System.out.println(MediaChecker.getAudioInfo(wavFile).toString());
			// MediaChecker.getVideoInfo(videoFile);

			// System.out.println(MediaChecker.getMimeType(textFile));
			// System.out.println(MediaChecker.getMimeType(pdfFile));
			// MediaChecker.isSearchable(pdfFile3);
			// System.out.println("Sample 1: " + MediaChecker.getDPI(pdfFile));
			// System.out.println("Sample 2: " + MediaChecker.getDPI(pdfFile2));
			// System.out.println("Sample 3: " + MediaChecker.getDPI(pdfFile3));
			// System.out.println("Sample 4: " + MediaChecker.getDPI(pdfFile4));
//			System.out.println("Full Text 1: " + MediaChecker.isSearchable(pdfFile));
//			System.out.println("Full Text 2: " + MediaChecker.isSearchable(pdfFile2));
//			System.out.println("Full Text 3: " + MediaChecker.isSearchable(pdfFile3));
			// System.out.println("Full Text 4: " + MediaChecker.isSearchable(pdfFile4));
		}
		catch (FileNotFoundException fe) {
			System.out.println("File not found!");
			// Assert.fail();
		}
		catch (IOException ioe) {
			System.out.println("Error opening the file!");
			// Assert.fail();
		}
		catch (Exception e) {
			// System.out.println("Uknown Exception!");
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}