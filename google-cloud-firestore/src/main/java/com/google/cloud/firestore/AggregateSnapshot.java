package com.google.cloud.firestore;

import com.google.cloud.Timestamp;
import java.util.Date;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface AggregateSnapshot {

  @Nonnull
  AggregateQuery getQuery();

  // Question: Is the read time meaningful for an aggregate snapshot?
  @Nonnull
  Timestamp getReadTime();

  @Nullable
  Map<FieldPath, Object> getData();

  // Question: Is it worthwhile to provide "contains" since all of the keys are
  // explicitly specified when the aggregate query is created?
  boolean contains(@Nonnull String field);
  boolean contains(@Nonnull FieldPath field);
  boolean contains(@Nonnull AggregateField field);

  // Question: Should we support custom object mapping? I think no, at least
  // in the initial release.
  <T> T toObject(@Nonnull Class<T> valueType);

  @Nullable
  Object get(@Nonnull String field);
  @Nullable
  <T> T get(@Nonnull String field, @Nonnull Class<T> valueType);
  @Nullable
  Object get(@Nonnull FieldPath field);
  @Nullable
  <T> T get(@Nonnull FieldPath field, @Nonnull Class<T> valueType);
  @Nullable
  Object get(@Nonnull AggregateField field);
  @Nullable
  <T> T get(@Nonnull AggregateField field, @Nonnull Class<T> valueType);

  @Nullable
  Boolean getBoolean(@Nonnull String field);
  @Nullable
  Boolean getBoolean(@Nonnull FieldPath field);
  @Nullable
  Boolean getBoolean(@Nonnull AggregateField field);

  @Nullable
  Double getDouble(@Nonnull String field);
  @Nullable
  Double getDouble(@Nonnull FieldPath field);
  @Nullable
  Double getDouble(@Nonnull AggregateField field);

  @Nullable
  String getString(@Nonnull String field);
  @Nullable
  String getString(@Nonnull FieldPath field);
  @Nullable
  String getString(@Nonnull AggregateField field);

  @Nullable
  Long getLong(@Nonnull String field);
  @Nullable
  Long getLong(@Nonnull FieldPath field);
  @Nullable
  Long getLong(@Nonnull AggregateField field);

  @Nullable
  Date getDate(@Nonnull String field);
  @Nullable
  Date getDate(@Nonnull FieldPath field);
  @Nullable
  Date getDate(@Nonnull AggregateField field);

  @Nullable
  Timestamp getTimestamp(@Nonnull String field);
  @Nullable
  Timestamp getTimestamp(@Nonnull FieldPath field);
  @Nullable
  Timestamp getTimestamp(@Nonnull AggregateField field);

  @Nullable
  Blob getBlob(@Nonnull String field);
  @Nullable
  Blob getBlob(@Nonnull FieldPath field);
  @Nullable
  Blob getBlob(@Nonnull AggregateField field);

  @Nullable
  GeoPoint getGeoPoint(@Nonnull String field);
  @Nullable
  GeoPoint getGeoPoint(@Nonnull FieldPath field);
  @Nullable
  GeoPoint getGeoPoint(@Nonnull AggregateField field);

  @Override
  boolean equals(Object obj);

  @Override
  int hashCode();
}
