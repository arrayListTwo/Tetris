package tools;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author arrayListTwo
 * 
 * �ض����ļ���׺������
 *
 */
public class ImageFilter implements FilenameFilter {

	private String nameSuffix = null;
	
	public ImageFilter(String suffix) {
		this.nameSuffix = suffix;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(nameSuffix);
	}

}
