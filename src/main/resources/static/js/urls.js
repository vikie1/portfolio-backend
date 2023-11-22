export const getUrl = (name) => {
  const mainApiUrl = "http://localhost:8080/api";
    const subUrls = {
      contact: mainApiUrl + "/contact",
      lfvBlogAPI: mainApiUrl + "/lfv/blogs",
      lfvCourseAPI: mainApiUrl + "/lfv/courses",
      lfvRoadMapsAPI: mainApiUrl + "/lfv/roadmaps"
    };
  return subUrls[name];
};
