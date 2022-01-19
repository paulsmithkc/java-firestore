package com.google.cloud.firestore;

import com.google.api.core.ApiFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;

public interface GroupByQuery {

  @Nonnull
  Query getQuery();

  @Nonnull
  GroupByAggregateQuery aggregate(@Nonnull AggregateField field, @Nonnull AggregateField... fields);

  @Nonnull
  GroupByQuery withMaxGroups(int maxGroups);

  @Nonnull
  GroupByQuery startingAtGroupOffset(long groupOffset);

  @Nonnull
  GroupByQuery startingAfterGroup(@Nonnull Object value, @Nonnull Object... values);

  @Nonnull
  GroupByQuery endingBeforeGroup(@Nonnull Object value, @Nonnull Object... values);

  // Question: This interface will almost always be used as an intermediary because the aggregations
  // will be specified to aggregate(), which returns a new object. The only case for calling get()
  // or addSnapshotListener() on this class would be to get the distinct set of combinations of the
  // fields being grouped.

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
