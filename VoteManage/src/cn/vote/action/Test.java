package cn.vote.action;


@SuppressWarnings("serial")
public class Test extends FileAction {
	
	public String doa() throws Exception {
		super.addImg("pagefile\\image\\");
		return "success";
	}

}
