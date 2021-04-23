package com.example.dgs_demo;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class TestResolver {
  @DgsQuery
  public boolean goodQuery(
     @InputArgument(name = "filter") String filter,
     @InputArgument(name = "size") int size,
     @InputArgument(name = "page") int page,
     @InputArgument(name = "sort") String sort
  ) {
    return true;
  }

  @DgsQuery
  public boolean badQuery(
      String filter,
      int size,
      int page,
      String sort
  ) {
    return true;
  }
}
