package com.google.cloud.firestore;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.Query.FieldOrder;
import com.google.cloud.firestore.Query.QueryOptions;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;

public interface GroupByQuery {

  @Nonnull
  Query getQuery();

  @Nonnull
  GroupByAggregateQuery aggregate(@Nonnull AggregateField field, @Nonnull AggregateField... fields);

  @Nonnull
  GroupByQuery groupLimit(int maxGroups);

  // Question: Do we want to support group-by "limitToLast" queries? In the Query class this is
  // implemented entirely client side by issuing the requested query with inverted order-by. We
  // would need to verify at runtime that the underlying query has the correct order-by clause and
  // possibly invert first/last aggregations to maintain their expected semantics.
  @Nonnull
  GroupByQuery groupLimitToLast(int maxGroups);

  @Nonnull
  GroupByQuery groupOffset(long groupOffset);

  @Nonnull
  GroupByQuery startAtGroup(Object... fieldValues);

  @Nonnull
  GroupByQuery startAtGroup(@Nonnull AggregateSnapshot snapshot);

  @Nonnull
  GroupByQuery startAfterGroup(Object... fieldValues);

  @Nonnull
  GroupByQuery startAfterGroup(@Nonnull AggregateSnapshot snapshot);

  @Nonnull
  GroupByQuery endAtGroup(Object... fieldValues);

  @Nonnull
  GroupByQuery endAtGroup(@Nonnull AggregateSnapshot snapshot);

  @Nonnull
  GroupByQuery endBeforeGroup(Object... fieldValues);

  @Nonnull
  GroupByQuery endBeforeGroup(@Nonnull AggregateSnapshot snapshot);

  @Nonnull
  GroupByQuery orderBy(@Nonnull String groupByField);

  @Nonnull
  GroupByQuery orderBy(@Nonnull FieldPath groupByField);

  @Nonnull
  GroupByQuery orderBy(@Nonnull AggregateField aggregateField);

  @Nonnull
  GroupByQuery orderBy(@Nonnull String groupByField, @Nonnull Direction direction);

  @Nonnull
  GroupByQuery orderBy(@Nonnull FieldPath groupByField, @Nonnull Direction direction);

  @Nonnull
  GroupByQuery orderBy(@Nonnull AggregateField aggregateField, @Nonnull Direction direction);

  // Question: This interface will almost always be used as an intermediary because the aggregations
  // will be specified to aggregate(), which returns a new object. The only case for calling get()
  // or addSnapshotListener() on this class would be to get the distinct set of combinations of the
  // fields being grouped.

  void stream(@Nonnull final ApiStreamObserver<GroupBySnapshot> responseObserver);

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
