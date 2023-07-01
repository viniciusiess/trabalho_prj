package view;

import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class UploadTask extends SwingWorker<Void, Integer> {
	private String uploadURL;
	  private File uploadFile;

	  public UploadTask(String uploadURL, File uploadFile) {
	    this.uploadURL = uploadURL;
	    this.uploadFile = uploadFile;
	  }

	  /**
	   * Executed in background thread
	   */
	  protected Void doInBackground() throws Exception {
	    try {
	      Upload util = new Upload(uploadURL,
	          "UTF-8");
	      util.addFilePart("uploadFile", uploadFile);

	      FileInputStream inputStream = new FileInputStream(uploadFile);
	      byte[] buffer = new byte[4096];
	      int bytesRead = -1;
	      long totalBytesRead = 0;
	      int percentCompleted = 0;
	      long fileSize = uploadFile.length();

	      while ((bytesRead = inputStream.read(buffer)) != -1) {
	        util.writeFileBytes(buffer, 0, bytesRead);
	        totalBytesRead += bytesRead;
	        percentCompleted = (int) (totalBytesRead * 100 / fileSize);
	        setProgress(percentCompleted);
	      }

	      inputStream.close();
	      util.finish();
	    } catch (IOException ex) {
	      JOptionPane.showMessageDialog(null, "Error uploading file: " + ex.getMessage(),
	          "Error", JOptionPane.ERROR_MESSAGE);
	      ex.printStackTrace();
	      setProgress(0);
	      cancel(true);
	    }

	    return null;
	  }

	  /**
	   * Executed in Swing's event dispatching thread
	   */
	  @Override
	  protected void done() {
	    if (!isCancelled()) {
	      JOptionPane.showMessageDialog(null,
	          "File has been uploaded successfully!", "Message",
	          JOptionPane.INFORMATION_MESSAGE);
	    }
	  }
}
