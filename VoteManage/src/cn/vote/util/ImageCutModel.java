package cn.vote.util;

/**
 * 该类负责为图片切割提供参数
 * 
 * @author 解金化
 * 
 * @date 2017.07.25
 *
 */
public class ImageCutModel {
	
	private String oldPath = ""; // 原来的图片存储地址
	private String newPath = ""; // 新的图片存储地址
	private int width = 0; // 图片宽度
	private int height = 0; // 图片高度
	private int x = 0; // 从哪儿开始截取 《从左到右》
	private int y = 0; // 从哪儿开始截取 《从上到下》

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getOldPath() {
		return oldPath;
	}
	public void setOldPath(String oldPath) {
		this.oldPath = oldPath;
	}
	public String getNewPath() {
		return newPath;
	}
	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}
}
