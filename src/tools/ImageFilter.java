package tools;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author arrayListTwo
 * 
 * 特定的文件后缀过滤器
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
