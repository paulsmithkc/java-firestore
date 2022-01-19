package com.google.cloud.firestore;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;

public interface AggregateQuery {

  @Nonnull
  Query getQuery();

  void stream(@Nonnull final ApiStreamObserver<AggregateSnapshot> responseObserver);

  @Nonnull
  ApiFuture<AggregateSnapshot> get();

  @Nonnull
  ListenerRegistration addSnapshotListener(@Nonnull EventListener<AggregateSnapshot> listener);

  @Nonnull
  ListenerRegistration addSnapshotListener(@Nonnull Executor executor, @Nonnull EventListener<AggregateSnapshot> listener);

  @Override
  int hashCode();

  @Override
  boolean equals(Object obj);

  @Override
  String toString();

}
