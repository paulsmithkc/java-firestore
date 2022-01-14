package com.google.cloud.firestore;

import com.google.api.core.ApiFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;

public interface GroupByAggregateQuery {

  @Nonnull
  GroupByQuery getQuery();

  @Nonnull
  ApiFuture<GroupBySnapshot> get();

  @Nonnull
  ListenerRegistration addSnapshotListener(@Nonnull EventListener<GroupBySnapshot> listener);

  @Nonnull
  ListenerRegistration addSnapshotListener(@Nonnull Executor executor,
      @Nonnull EventListener<GroupBySnapshot> listener);

  @Override
  int hashCode();

  @Override
  boolean equals(Object obj);

  @Override
  String toString();

}
