package com.jewel.http.business;

import com.jewel.http.core.IHttpCallback;
import com.jewel.model.ExamCategories;
import com.jewel.model.ExamData;
import com.jewel.model.ListData;

import java.util.List;

public interface IExamRequest {

    int WHAT_QUESTION_1 = 1;
    int WHAT_QUESTION_4 = 2;
    int WHAT_CATEGORY = 3;
    int WHAT_CATEGORY_DETAIL = 4;

    void getQuestion1(int page, IHttpCallback<List<ExamData>> callback);

    void getQuestion4(int page, IHttpCallback<List<ExamData>> callback);

    void getCategory(IHttpCallback<List<ExamCategories>> callback);

    void getCategoryDetail(String cid, int page, IHttpCallback<List<ExamData>> callback);

}
