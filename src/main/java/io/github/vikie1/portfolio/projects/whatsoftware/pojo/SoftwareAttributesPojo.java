package io.github.vikie1.portfolio.projects.whatsoftware.pojo;

/**
 * @param type Check README.md at the root of the project
 */
public record SoftwareAttributesPojo(String softwareName, String description, String downloadUrl, String type,
                                     String category, String parentCategory, boolean isNested) {
}
