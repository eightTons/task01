//package cn.edu.bnuz.VO;
//
//import com.ustcsoft.jt.mybatis.Page;
//
//import java.util.List;
//
//public class LayeruiVO {
//    private Integer code;
//    private String msg;
//    private Integer count;
//    private List<?> data;
//    public LayeruiVO() {
//    }
//    public LayeruiVO(Page<?> page) {
//        if(page!=null){
//            this.code=200;
//            this.msg="msg";
//            this.count = page.getRecordCount();
//            this.data = page.getItems();
//        }
//    }
//    public Integer getCode() {
//        return code;
//    }
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//    public String getMsg() {
//        return msg;
//    }
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//    public Integer getCount() {
//        return count;
//    }
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//    public List<?> getData() {
//        return data;
//    }
//    public void setData(List<?> data) {
//        this.data = data;
//    }
//}
//
//
