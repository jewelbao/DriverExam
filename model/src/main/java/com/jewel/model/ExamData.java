package com.jewel.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import lombok.Data;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 驾考题实体
 */
@Entity
@Data
public class ExamData {
    /**
     * a : 正确
     * b : 错误
     * c :
     * d :
     * explainText : 试题解释：和谐第一，做题就要假扮圣人，人家要超车就减速靠右给他让出超车的位置。
     * file :
     * id : 4987
     * tikuType : select
     * title : 遇后车超车时，在条件许可的情况下应减速靠右让路，是为了给后车留出超车空间。
     * val : 1
     */
    @Id
    private String id;
    /**
     * 题库类型:判断题-judge ; 选择题-select
     */
    private String tikuType;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片文件链接url
     */
    private String file;
    private String a;
    private String b;
    private String c;
    private String d;
    /**
     * 答案选项（如果是选择题，则1-a,2-b,3-c,4-d；如果是判断题，则1=正确，0=错误）
     */
    private String val;
    /**
     * 答案解释
     */
    private String explainText;

    private int total;

    @Generated(hash = 1038622364)
    public ExamData(String id, String tikuType, String title, String file, String a,
            String b, String c, String d, String val, String explainText,
            int total) {
        this.id = id;
        this.tikuType = tikuType;
        this.title = title;
        this.file = file;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.val = val;
        this.explainText = explainText;
        this.total = total;
    }

    @Generated(hash = 596609427)
    public ExamData() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTikuType() {
        return this.tikuType;
    }

    public void setTikuType(String tikuType) {
        this.tikuType = tikuType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getA() {
        return this.a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return this.b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return this.c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return this.d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getVal() {
        return this.val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getExplainText() {
        return this.explainText;
    }

    public void setExplainText(String explainText) {
        this.explainText = explainText;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
