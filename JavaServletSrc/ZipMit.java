import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
public class ZipMit {

//---Start function: getMcCelle
public MemoryCursor_mccellaexcel_mcrdef getMcCelle() {
  return mcCelle;
}
//---End function

//---Start function: setMcCelle
public void setMcCelle(MemoryCursor_mccellaexcel_mcrdef pmcCelle) {
  mcCelle = new MemoryCursor_mccellaexcel_mcrdef();
  mcCelle=pmcCelle;
}
//---End function

//---Start function: unzip
public void unzip(String zipFilePath, String destDirPath) {
  mcCelle = new MemoryCursor_mccellaexcel_mcrdef();
  try (ZipFile zipFile = new ZipFile(zipFilePath)) {
			Stream<? extends ZipEntry> stream = zipFile.stream();
			stream.forEach(zipEntry -> {
				byte[] buffer = new byte[1024];
				try (InputStream inputStream = zipFile.getInputStream(zipEntry);            
						BufferedInputStream bufferInStream = new BufferedInputStream(inputStream);
						BufferedOutputStream bufferOutStream = new BufferedOutputStream(
								new FileOutputStream(destDirPath + File.separator + zipEntry.getName()));) {
					int bytes = 0;
          mcCelle.AppendBlank();
          mcCelle.row.memo =zipEntry.getName();
					while ((bytes = bufferInStream.read(buffer)) > 0) {
						bufferOutStream.write(buffer, 0, bytes);
						bufferOutStream.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
	}
}
//---End function

//---Start function: zip
public void zip(String zipFilePath, List<File> files) {
  try (FileOutputStream outputStream = new FileOutputStream(zipFilePath);
			 ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
			 BufferedOutputStream bufferOutStream = new BufferedOutputStream(zipOutputStream);) {
	     		files.forEach(file -> {
				byte[] buffer = new byte[1024];
				try (FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bufferInStream = new BufferedInputStream(fis);) {
					ZipEntry zipEntry = new ZipEntry(file.getName());
					zipOutputStream.putNextEntry(zipEntry);
					int bytes = 0;
					while ((bytes = bufferInStream.read(buffer)) > 0) {
						bufferOutStream.write(buffer, 0, bytes);
						bufferOutStream.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
	}
}
public void zip(String zipFilePath, String filetozip) {
//  List<File> files = Arrays.asList(new File(filetozip));
  List<File> files = new ArrayList<File>();
  files.add(new File(filetozip));
  zip(zipFilePath,files);
}
public void zip(String zipFilePath) {
  List<File> files = new ArrayList<File>();
  mcCelle.GoTop();
  while (!(mcCelle.Eof())) {
    files.add(new File(mcCelle.row.memo));
    mcCelle.Next();
  }
  zip(zipFilePath,files);
}
//---End function

//---Start attributes
public MemoryCursor_mccellaexcel_mcrdef mcCelle;
//---End attributes
}
