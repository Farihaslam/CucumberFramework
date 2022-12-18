@Smoketest
Feature: Verify STC TV Plans and Details

  @tag1
  Scenario Outline: Validate Information of Subscription Packages
    Given User Is on Landing Page
    When <Country> Is selected In Dropdown
    Then Validate Lite Price <Lite Prices>, Classic Prices <Classic Prices> and Premium <Premium Prices> with Currency <Currency> for all Countries <Country>
    
    Examples: 
      | Country | Lite Prices | Classic Prices | Premium Prices | Currency  |
      | KSA     |          15 |             25 |             60 | SAR/month |
      | Bahrain |           2 |              30 |              6 | BHD/month |
      | Kuwait  |         1.2 |            2.5 |            4.8 | KWD/month |
