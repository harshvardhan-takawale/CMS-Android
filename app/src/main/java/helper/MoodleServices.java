package helper;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import set.Course;
import set.CourseSection;
import set.enrol.SelfEnrol;
import set.search.CourseSearch;
import set.forum.SiteNews;

/**
 * Created by harsu on 16-12-2016.
 */

public interface MoodleServices {
    @GET("webservice/rest/server.php?wsfunction=core_enrol_get_users_courses&moodlewsrestformat=json")
    Call<ResponseBody> getCourses(@Query("wstoken") String token, @Query("userid") int userID);

    @GET("webservice/rest/server.php?wsfunction=core_course_get_contents&moodlewsrestformat=json")
    Call<List<CourseSection>> getCourseContent(@Query("wstoken") String token, @Query("courseid") int courseID);

    @GET("webservice/rest/server.php?wsfunction=core_course_search_courses&moodlewsrestformat=json&criterianame=search")
    Call<CourseSearch> getSearchedCourses(@Query("wstoken") String token,
                                          @Query("criteriavalue") String courseName,
                                          @Query("page") int page,
                                          @Query("perpage") int numberOfResults);

    @GET("webservice/rest/server.php?wsfunction=enrol_self_enrol_user&moodlewsrestformat=json")
    Call<SelfEnrol> selfEnrolUserInCourse(@Query("wstoken") String token, @Query("courseid") int courseId);

    @GET("webservice/rest/server.php?wsfunction=mod_forum_get_forum_discussions_paginated&moodlewsrestformat=json&forumid=1&sortby=timemodified&sortdirection=DESC")
    Call<SiteNews> getForumDiscussions(@Query("wstoken") String token,
                                       @Query("forumid") int forumid,
                                       @Query("page") int page,
                                       @Query("perpage") int perpage);
}
