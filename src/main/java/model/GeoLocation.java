package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
@ToString
public class GeoLocation {
  private String userCountryCode;
  private String userRegionCode;
  private String userRegion;
  private String userCity;
  private String userLatitude;
  private String userLongitude;
  private String userTimeZone;
  private String userPostalCode;
}
