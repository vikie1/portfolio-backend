export const getUrl = (name) => {
    const subUrls = {
      contact: "/api/contact",
      lfvBlogAPI: "/api/lfv/blogs",
      lfvCourseAPI: "/api/lfv/courses",
      lfvRoadMapsAPI: "/api/lfv/roadmaps"
    };
  return subUrls[name];
};