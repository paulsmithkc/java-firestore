package com.google.cloud.firestore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AggregateField {

  private AggregateField() {}

  /**
   * Calculates and returns the alias to use for this aggregate field in the proto.
   *
   * <p>This methods would NOT be part of the public API but it is being listed here to show how
   * aliases would be generated.
   */
  public abstract String getAlias();

  /**
   * Returns the {@link AggregateField} that generated the given alias.
   *
   * @param alias the alias whose {@link AggregateField} to return.
   * @return The {@link AggregateField} for the given alias, or {@code null} if the given alias does
   *     not map to a known aggregate field.
   */
  @Nullable
  public static AggregateField fromAlias(@Nonnull String alias) {
    {
      CountAggregateField countAggregateField = CountAggregateField.fromAlias(alias);
      if (countAggregateField != null) {
        return countAggregateField;
      }
    }
    {
      MinAggregateField minAggregateField = MinAggregateField.fromAlias(alias);
      if (minAggregateField != null) {
        return minAggregateField;
      }
    }
    {
      MaxAggregateField maxAggregateField = MaxAggregateField.fromAlias(alias);
      if (maxAggregateField != null) {
        return maxAggregateField;
      }
    }
    {
      AverageAggregateField averageAggregateField = AverageAggregateField.fromAlias(alias);
      if (averageAggregateField != null) {
        return averageAggregateField;
      }
    }
    {
      SumAggregateField sumAggregateField = SumAggregateField.fromAlias(alias);
      if (sumAggregateField != null) {
        return sumAggregateField;
      }
    }
    {
      FirstAggregateField firstAggregateField = FirstAggregateField.fromAlias(alias);
      if (firstAggregateField != null) {
        return firstAggregateField;
      }
    }
    {
      LastAggregateField lastAggregateField = LastAggregateField.fromAlias(alias);
      if (lastAggregateField != null) {
        return lastAggregateField;
      }
    }
    return null;
  }

  @Nonnull
  public static CountAggregateField count() {
    return new CountAggregateField();
  }

  @Nonnull
  public static MinAggregateField min(@Nonnull String field) {
    return min(FieldPath.fromDotSeparatedString(field));
  }

  @Nonnull
  public static MinAggregateField min(@Nonnull FieldPath field) {
    return new MinAggregateField(field);
  }

  @Nonnull
  public static MaxAggregateField max(@Nonnull String field) {
    return max(FieldPath.fromDotSeparatedString(field));
  }

  @Nonnull
  public static MaxAggregateField max(@Nonnull FieldPath field) {
    return new MaxAggregateField(field);
  }

  @Nonnull
  public static AverageAggregateField average(@Nonnull String field) {
    return average(FieldPath.fromDotSeparatedString(field));
  }

  @Nonnull
  public static AverageAggregateField average(@Nonnull FieldPath field) {
    return new AverageAggregateField(field);
  }

  @Nonnull
  public static SumAggregateField sum(@Nonnull String field) {
    return sum(FieldPath.fromDotSeparatedString(field));
  }

  @Nonnull
  public static SumAggregateField sum(@Nonnull FieldPath field) {
    return new SumAggregateField(field);
  }

  @Nonnull
  public static FirstAggregateField first(@Nonnull String field) {
    return first(FieldPath.fromDotSeparatedString(field));
  }

  @Nonnull
  public static FirstAggregateField first(@Nonnull FieldPath field) {
    return new FirstAggregateField(field);
  }

  @Nonnull
  public static LastAggregateField last(@Nonnull String field) {
    return last(FieldPath.fromDotSeparatedString(field));
  }

  @Nonnull
  public static LastAggregateField last(@Nonnull FieldPath field) {
    return new LastAggregateField(field);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Nullable
  static FieldPath decodeFieldPathAliasWithPrefix(@Nonnull String alias, @Nonnull String prefix) {
    if (!alias.startsWith(prefix)) {
      return null;
    } else {
      String encodedFieldPath = alias.substring(alias.length());
      return FieldPath.fromEncodedPath(encodedFieldPath);
    }
  }

  public static class CountAggregateField extends AggregateField {

    private static final String ALIAS = "AGG COUNT";

    private CountAggregateField() {}

    public CountAggregateField withMaxCount(int maxCount) {
      return null;
    }

    @Override
    public String getAlias() {
      return ALIAS;
    }

    @Nullable
    public static CountAggregateField fromAlias(@Nonnull String alias) {
      return alias.equals(ALIAS) ? new CountAggregateField() : null;
    }
  }

  public static class MinAggregateField extends AggregateField {

    private static final String ALIAS_PREFIX = "AGG MIN ";

    @Nonnull private FieldPath field;

    private MinAggregateField(@Nonnull FieldPath field) {
      this.field = field;
    }

    @Override
    public String getAlias() {
      return ALIAS_PREFIX + field.getEncodedPath();
    }

    @Nullable
    public static MinAggregateField fromAlias(@Nonnull String alias) {
      FieldPath field = decodeFieldPathAliasWithPrefix(alias, ALIAS_PREFIX);
      return field == null ? null : new MinAggregateField(field);
    }
  }

  public static class MaxAggregateField extends AggregateField {

    private static final String ALIAS_PREFIX = "AGG MAX ";

    @Nonnull private FieldPath field;

    private MaxAggregateField(@Nonnull FieldPath field) {
      this.field = field;
    }

    @Override
    public String getAlias() {
      return ALIAS_PREFIX + field.getEncodedPath();
    }

    @Nullable
    public static MaxAggregateField fromAlias(@Nonnull String alias) {
      FieldPath field = decodeFieldPathAliasWithPrefix(alias, ALIAS_PREFIX);
      return field == null ? null : new MaxAggregateField(field);
    }
  }

  public static class AverageAggregateField extends AggregateField {

    private static final String ALIAS_PREFIX = "AGG AVERAGE ";

    @Nonnull private FieldPath field;

    private AverageAggregateField(@Nonnull FieldPath field) {
      this.field = field;
    }

    @Override
    public String getAlias() {
      return ALIAS_PREFIX + field.getEncodedPath();
    }

    @Nullable
    public static AverageAggregateField fromAlias(@Nonnull String alias) {
      FieldPath field = decodeFieldPathAliasWithPrefix(alias, ALIAS_PREFIX);
      return field == null ? null : new AverageAggregateField(field);
    }
  }

  public static class SumAggregateField extends AggregateField {

    private static final String ALIAS_PREFIX = "AGG SUM ";

    @Nonnull private FieldPath field;

    private SumAggregateField(@Nonnull FieldPath field) {
      this.field = field;
    }

    @Override
    public String getAlias() {
      return ALIAS_PREFIX + field.getEncodedPath();
    }

    @Nullable
    public static SumAggregateField fromAlias(@Nonnull String alias) {
      FieldPath field = decodeFieldPathAliasWithPrefix(alias, ALIAS_PREFIX);
      return field == null ? null : new SumAggregateField(field);
    }
  }

  public static class FirstAggregateField extends AggregateField {

    private static final String ALIAS_PREFIX = "AGG FIRST ";

    @Nonnull private FieldPath field;

    private FirstAggregateField(@Nonnull FieldPath field) {
      this.field = field;
    }

    @Override
    public String getAlias() {
      return ALIAS_PREFIX + field.getEncodedPath();
    }

    @Nullable
    public static FirstAggregateField fromAlias(@Nonnull String alias) {
      FieldPath field = decodeFieldPathAliasWithPrefix(alias, ALIAS_PREFIX);
      return field == null ? null : new FirstAggregateField(field);
    }
  }

  public static class LastAggregateField extends AggregateField {

    private static final String ALIAS_PREFIX = "AGG LAST ";

    @Nonnull private FieldPath field;

    private LastAggregateField(@Nonnull FieldPath field) {
      this.field = field;
    }

    @Override
    public String getAlias() {
      return ALIAS_PREFIX + field.getEncodedPath();
    }

    @Nullable
    public static LastAggregateField fromAlias(@Nonnull String alias) {
      FieldPath field = decodeFieldPathAliasWithPrefix(alias, ALIAS_PREFIX);
      return field == null ? null : new LastAggregateField(field);
    }
  }
}
