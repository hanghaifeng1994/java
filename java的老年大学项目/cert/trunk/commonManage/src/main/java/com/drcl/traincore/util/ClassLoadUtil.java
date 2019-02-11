package com.drcl.traincore.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassLoadUtil extends ClassLoader {
	private boolean delete = false;
	private boolean load = false;
	private String path = ClassLoadUtil.class.getClassLoader().getResource("").getPath();
	private File classpath = new File(ClassLoadUtil.class.getClassLoader().getResource("").getPath());
	public ClassLoadUtil() {
		super();//让系统加载器成为该类的加载器的父类加载器
	}
	public ClassLoadUtil(ClassLoader parent) {
		super(parent); //显示指定该类加载器的父加载器
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = this.loadClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}
	/**
	 * 读取class文件作为二进制流放入到byte数组中去
	 * 
	 * @param name
	 * @return
	 */
	private byte[] loadClassData(String name) {
		InputStream in = null;
		byte[] data = null;
		ByteArrayOutputStream baos = null;
		try {
			name = name.replace(".", "//");  
			in = new BufferedInputStream(new FileInputStream(new File(path + name + ".class")));
			baos = new ByteArrayOutputStream();
			int ch = 0;
			while (-1 != (ch = in.read())) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	public void loadAllClazzByPath(File classpath) throws Exception {
			File[] fs = classpath.listFiles();
			for (int i = 0; i < fs.length; i++) {
				if (fs[i].isDirectory()) {
					try {
						loadAllClazzByPath(fs[i]);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					if("class".equals(fs[i].getName().substring(fs[i].getName().lastIndexOf(".") + 1,fs[i].getName().length()))){//class 文件
						String pack = fs[i].getAbsolutePath().substring(this.classpath.getAbsoluteFile().toString().length()+1, fs[i].getAbsolutePath().toString().length()-1);
						pack = pack.substring(0,pack.lastIndexOf("."));
						pack = pack.replaceAll("\\\\", ".");
						pack = pack.replaceAll("/", ".");
						System.out.println("加载:"+pack);
						Class.forName(pack);
					}
				}
			}
	}
	private void recurDelete(File f){
	    for(File fi:f.listFiles()){
	        if(fi.isDirectory()){
	            recurDelete(fi);
	        } else{
				if("class".equals(fi.getName().substring(fi.getName().lastIndexOf(".") + 1,fi.getName().length()))){
					fi.delete();
					//System.out.println("删除:"+fi.getAbsolutePath()+"完毕");
				}
	        }
	    }
	}
	public void init(){
			try {//加载类
				if(load){
					ClassLoadUtil classloadutil = new ClassLoadUtil(this.getClass().getClassLoader()); 
					classloadutil.loadAllClazzByPath(classpath);
					System.out.println("class已经加载完毕");
				}
			} catch (Exception e) {
				System.out.println("自定义加载class失败..............");
				e.printStackTrace();
			}
			try {//删除类
				if(delete){
					File[] files = classpath.listFiles();
					for(File f:files){
						if(f.isDirectory()){
							recurDelete(f);
						}else{
							if("class".equals(f.getName().substring(f.getName().lastIndexOf(".") + 1,f.getName().length()))){
								f.delete();
								System.out.println("删除:"+f.getAbsolutePath()+"完毕");
							}
						}
					}
					System.out.println("class已经全部删除");
				}
			} catch (Exception e) {
				System.out.println("删除class失败..............");
				e.printStackTrace();
			}
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public boolean isLoad() {
		return load;
	}
	public void setLoad(boolean load) {
		this.load = load;
	}
	
}
