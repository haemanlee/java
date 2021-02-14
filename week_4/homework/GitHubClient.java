package homework;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class GitHubClient {
  GitHub github;

  public GitHubClient(String token) {
    try {
      GitHubBuilder builder = new GitHubBuilder();
      this.github = builder.withOAuthToken(token).build();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<GHIssue> getIssues(String repoName) {
    try {
      GHRepository repo = this.github.getRepository(repoName);
      return repo.getIssues(GHIssueState.ALL);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public Map<String, List<GHIssue>> getComments(List<GHIssue> issues) {
    Map<String, List<GHIssue>> participatePerUser = new HashMap<>();
    for (GHIssue issue : issues) {
      try {
        List<GHIssueComment> comments = issue.getComments();
        Set<String> names = new HashSet<>();
        for (GHIssueComment comment : comments) {
          String name = comment.getUser().getName();
          names.add(name);
        }
        for (String name : names) {
          if (participatePerUser.containsKey(name)) participatePerUser.get(name).add(issue);
          else {
            List<GHIssue> newIssusList = new ArrayList<>();
            newIssusList.add(issue);
            participatePerUser.put(name, newIssusList);
          }
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return participatePerUser;
  }

  public void showStatistics(Map<String, List<GHIssue>> participatePerUser) {
    System.out.println("[참여 현황 (전체 18개 과제 중 수행률]");
    for (Map.Entry<String, List<GHIssue>> nameIssues : participatePerUser.entrySet()) {
      System.out.println("User '" + nameIssues.getKey() + "' : " + nameIssues.getValue().size() / 18 + "%");
    }
  }
}