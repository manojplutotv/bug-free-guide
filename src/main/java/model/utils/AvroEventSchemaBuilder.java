package model.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static model.utils.AvroCommonTypes.*;

/**
 * Run this class will print out avro JSON schema which can be copied to /resources/schemas/event-data-payload.avsc.
 * With this avsc file, AVRO will create a class automatically by "mvn clean install" command.
 */
@Slf4j
public class AvroEventSchemaBuilder {

  /** Event name enumeration. */
  private static final Schema EVENT_NAME_ENUM =
      Schema.createEnum(
          "EventName",
          "Identifies the Name of the Event being fired.",
          "tv.pluto.nile.avro",
          Arrays.asList(
              "clipStart",
              "clipEnd",
              "episodeStart",
              "episodeEnd",
              "heartBeat",
              "linkClick",
              "channelChange",
              "vodSeriesPreview",
              "vodEpisodePreview",
              "vodEpisodeWatch",
              "hideChannel",
              "unhideChannel",
              "likeChannel",
              "unlikeChannel",
              "scrollVertical",
              "scrollHorizontal",
              "clickVolume",
              "tiltScreen",
              "swipeVertical",
              "swipeHorizontal",
              "sectionSelect",
              "castRequest",
              "clickPlay",
              "clickPause",
              "clickStop",
              "clickForward",
              "clickRewind",
              "clickSkipForward",
              "clickSkipRewind",
              "clickScrubStart",
              "clickScrubStop",
              "pageView",
              "cmPodStart",
              "cmPodEnd",
              "cmStart",
              "cmImpression",
              "cmFirstQuartile",
              "cmMidPoint",
              "cmThirdQuartile",
              "cmComplete",
              "cmEnd",
              "cmError",
              "cmClickThru",
              "cmSkip",
              "cmPodRequestSent",
              "cmPodRequestReceived",
              "cmPodResponseReceived",
              "cmWrapperRequestSent",
              "cmWrapperResponseReceived",
              "cmRejected",
              "cmAccepted",
              "cmTranscodeRequestSent",
              "cmHouseCmRequestSent",
              "cmHouseCmResponseReceived",
              "cmPodResponseSent",
              "cmCreatedNew",
              "cmExistsRequestSent",
              "cmExistsResponseReceived",
              "cmFillerAdded",
              "cmInterstitialRequestSent",
              "cmInterstitialResponseReceived",
              "appLaunch",
              "uILoaded",
              "channelGuideRequest",
              "channelGuideLoaded",
              "videoRequest",
              "videoLoaded",
              "appLoaded",
              "signInSuccessful",
              "signUpSuccessful",
              "signOutSuccessful",
              "castRequestSuccessful",
              "castRequestFailure",
              "displayOverlay",
              "pairingGenerateCode",
              "pairingSuccessSecondary",
              "pairingSuccessPrimary",
              "pairingCodeInvalid",
              "pairingRemovedSecondary",
              "pairingRemovedPrimary",
              "pushOpt",
              "videoResolutionChanged",
              "videoBitrateChanged",
              "appLoadError",
              "appLaunchTrack",
              "channelError",
              "videoError",
              "undefinedError",
              "playerBufferStart",
              "playerBufferEnd",
              "pairingError",
              "testEntry",
              "testExit",
              "subtitleOn",
              "subtitleOff",
              "searchIntegrationLaunch",
              "changePlaybackState",
              "cmBegin",
              "cmPodBegin",
              "cmPodComplete",
              "cmServed",
              "cmBidRequestSent",
              "cmBidResponseReceived",
              "sessionReset",
              "appBackgrounded",
              "appForegrounded",
              "pushReceived",
              "pushClicked",
              "cmRequestSent",
              "cmResponseReceived",
              "cmStitched",
              "cmBucketRequestReceived",
              "cmBucketRequestSent",
              "cmGenerated",
              "cmSent",
              "cmReceived",
              "cmTagSent",
              "cmTagReceived",
              "cmNoAd",
              "testInProgress",
              "bootstrapRequest",
              "bootstrapLoaded",
              "policyAccepted",
              "policyViewed",
              "policyViewedAccepted",
              "userAction",
              "castSuccess",
              "castFail",
              "castDisconnectSuccess",
              "castDisconnectFail",
              "castError",
              "castDisconnectRequest",
              "bootstrapRestartRequest",
              "impressionNonAd"
          ));

  public static void main(String[] args) throws IOException {
    log.info("Starting building Odin Event Schema for Avro");

    Schema eventSchema = SchemaBuilder
        .record("EventDataPayload")
        .namespace("tv.pluto.nile.avro")
        .fields()

        .name("accountId")
        .doc("""
           This is the unique registered user ID of the User who is using the app at the time the
           Event is fired. This applies only if the User has signed in. This used to be called
           UserId.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("appId")
        .doc("Unique identifier for website / application.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("appName")
        .doc("Identifies the name of Application.")
        .type(STRING).noDefault()

        .name("appSubName")
        .doc("""
            Sub-name will identify sub-classifications underneath an appName, if any. This field
            will not apply to all apps. Only to apps that have breakdowns underneath the main
            appName. As an example, for some distribution partners, such as "tivo", there could be
            situations where they lease or sell their boxes to affiliates. This field will be used
            to distinguish between those affiliates. In the case of tivo this field is called
            "msoName".""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("appVersion")
        .doc("""
            Identifies the version of the Application. Please Note: this field should be dynamically
            populated from the github repository of the code in order to avoid errors of hard-coding.
            Also the correct build number should be included when populating this field.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("appPlatform")
        .doc("The platform the app runs on.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientBrowserName")
        .doc("Identifies the browser name used on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientBrowserVersion")
        .doc("Identifies the browser version used on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("carrierName")
        .doc("Identifies the name of the Carrier providing the cellular or Internet service.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientChipset")
        .doc("Identifies the Chipset used on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientDeviceFamily")
        .doc("Identifies the Chipset used on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientDeviceType")
        .doc("""
            Identifies the Device Type. This is a field that is used for defining Advertising deals
            and is defined based on the IAB open RTB (real time bidding) standards. This could
            probably be hard-coded for some apps, such as "androidmobile" where there could only be
            one device type, but in other apps, such as web and msn, this would have to be
            dynamically populated, because the same app can be used on multiple device types
            One can use the app on the browser of a mobile, a tablet, a personal computer or any
            other device that has a browser.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("clientEmbedPartner")
        .doc("Identifies the Embed site publisher's name.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientFirmware")
        .doc("Identifies the Firmware running on the Client.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientId")
        .doc("""
            Uniquely identifies Client device or browser on which the app is running. This is used
            extensively as a proxy for the User using PlutoTV app since the vast majority of PlutoTV
            users are not registered. Different apps have different methods of generating/capturing
            the clientID value. ClientID is referred to as device_id, deviceId or client_id in the
            legacy Events framework.""")
        .type(STRING).noDefault()

        .name("clientLanguage")
        .doc("Identifies the default language used on the app.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientManufacturer")
        .doc("Identifies the Manufacturer of the Client Device on which the PlutoTV app is running.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientModelName")
        .doc("Identifies the Model name of the Client Device on which the PlutoTV app is running.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientModelNumber")
        .doc("Identifies the Model number of the Client Device on which the PlutoTV app is running.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientNetworkType")
        .doc("""
            Identifies whether the Device is on a cellular network or a WIFI network at the time
            the Event is fired.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientOs")
        .doc("Identifies the Operating System running on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientOsFamily")
        .doc("Identifies the Family of the Operating System running on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientOsVersion")
        .doc("Identifies the Family of the Operating System running on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientOsMajor")
        .doc("Identifies the Major version of the Operating System running on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientOsMinor")
        .doc("Identifies the Minor version of the Operating System running on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientOsPatch")
        .doc("Identifies the Patch version of the Operating System running on the Client Device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientOsTimeZone")
        .doc("Time zone of client device’s OS.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientPrivateIp")
        .doc("Identifies the private IP address of the client device.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientScreenResolution")
        .doc("Identifies the Screen Resolution of the client on which the app is running.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientUserAgent")
        .doc("User agent (a.k.a. browser string).")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientUserAgentFamily")
        .doc("User agent family from the client user agent string.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientUserAgentVersion")
        .doc("User agent version from the client user agent string.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientUserAgentMajor")
        .doc("User agent major version from the client user agent string.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientUserAgentMinor")
        .doc("User agent minor version from the client user agent string.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientUserAgentPatch")
        .doc("User agent patch version from the client user agent string.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clientDnt")
        .doc("Identifies whether the User has chosen to opt out of any Ad tracking on the device.")
        .type(OPTIONAL_BOOLEAN).withDefault(null)

        .name("clientIp")
        .doc("IP address.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("channelId")
        .doc("""
            Identifies the CMS Channel ID of the Channel being watched by the User when the Event
            is fired.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clipId")
        .doc("Identifies the CMS Clip ID of the Clip being watched when the Event is fired.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("clipTimelinePoint")
        .doc("""
            Identifies the point in the Clip (hh:mm:ss) at the time the Event is fired. This should
            be populated from the clip metadata.""")
        .type(OPTIONAL_LONG).withDefault(null)

        .name("cmAudienceId")
        .doc("Identifies the Client-specific advertising ID (i.e. Apple IDFA, Google GAID, etc.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmBidFloor")
        .doc("Identifies the Client-specific advertising ID (i.e. Apple IDFA, Google GAID, etc.")
        .type(OPTIONAL_DOUBLE).withDefault(null)

        .name("cmCpm")
        .doc("Identifies the CPM of the ad (provided by Ad Proxy).")
        .type(OPTIONAL_DOUBLE).withDefault(null)

        .name("cmCpmCurrencyCode")
        .doc("Identifies the standard (ISO) currency code that the adCPM is based in.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmDealId")
        .doc("""
            Identifies the unique value for an ad creative within a specific deal the Pluto has with
            the Ad server (spotx, amazon, etc.).""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmDurationOriginal")
        .doc("Identifies the original duration of the ad being viewed.")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("cmDurationServed")
        .doc("""
            Identifies the actual duration for which the ad ran for that user in that session in
            that instance. This is different from "cmDurationOriginal" in that "cmDurationServed"
            may be less if the ad errored out or the user switched channels while watching an ad or
            if the user starts watching after the ad started.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("cmId")
        .doc("""
            Identifies the Ad-ID, which is the advertising industry standard unique identifier for
            all commercial assets airing in America. In Ad Proxy, this is adID.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmImpressionCounter")
        .doc("""
            Running counter of the Impressions within the user viewing session. It starts from 1 and
            increments by 1 throughout the viewing session. Resets with every new Session.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("cmImpressionId")
        .doc("""
            Identifies the unique ID of the impression across all time and across all users,
            probably at at ad server level. If this exists, then it can be used to link back to the
            metadata in freewheel, for example, to get other details about that particular ad
            impression.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmImpressionIndex")
        .doc("""
            Position of the ad being played within the pod. It starts from 1 and resets with every
            Ad Pod.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("cmNetworkId")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmNetworkName")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmPlacementId")
        .doc("""
            Per Freewheel documentation, this is The ID of the placement that was served to the user.
            This value comes directly from the FreeWheel database.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmPlutoId")
        .doc("""
            Identifies the unique Pluto ID assigned to the Ad, Interstitial or Filler. This is
            sometimes referred to as creative ID within Stitcher and Ad Proxy. It is the Mongo ID
            for every creative we have in the database. This is an internal Pluto ID to track Ads
            that have been transcoded.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmPodCounter")
        .doc("Starts at 1, and increments with every new Ad Pod. Resets with every new Session.")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("cmPodDuration")
        .doc("Starts at 1, and increments with every new Ad Pod. Resets with every new Session.")
        .type(OPTIONAL_LONG).withDefault(null)

        .name("cmPodId")
        .doc("Identifies the unique Ad Pod ID provided by AdProxy (adbreakid parameter in AdProxy).")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmPodIndex")
        .doc("Starts at 1, and increments with every new Ad Pod. Resets with every new Episode.")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("cmPodRequestId")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmProviderDomain")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmProxyVersion")
        .doc("Identifies the version of the adProxy software.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmRequestCounter")
        .doc("""
            Identifies the running tally of the ad requests within the User viewing session.
            It starts at 1 and resets with every new session.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("cmRequestId")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmServerId")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmServerName")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmSiteSectionId")
        .doc("""
            Identifies the site section id within freewheel. This is a variable in the Freewheel
            rules engine that is used to determine the ad served. It roughly denotes the device and
            channel that the ad is requested for. Freewheel uses this (Site information) and clipID
            (Video information) to run rules to determine which placement within a campaign can be
            used to satisfy the adPod request from adProxy for the particular device and channel
            requesting the ad.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmTagUrl")
        .doc("""
            Identifies the adTag used for the 1st 'hop' (i.e. URL provided by the adServer with
            which adProxy will make the wrapper request for the ad) in the ad serving process.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmTitle")
        .doc("""
            Identifies the Title of the Ad, also known as adTitle. This is currently available in
            the adProxy.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("cmType")
        .doc("""
            Identifies what was played in the Ad slot - an actual Ad, a Promo, an Interstitial or a
            Filler. This is referred to as Creative Type within Mongo DB.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventNameSp")
        .doc("Event type (Snowplow categorization).")
        .type(STRING).withDefault("unstruct")

        .name("eventCategory")
        .doc("Identifies the Category that the Event belongs to.")
        .type(STRING).noDefault()

        .name("eventEmitterName")
        .doc("Identifies the name of the Entity that fired the Event.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventEmitterType")
        .doc("Identifies the type of the System that fired the Event.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventGeneratorIp")
        .doc("Identifies the IP address of the System that generated the Event URL.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventGeneratorName")
        .doc("Identifies the name of the Entity that generated the Event payload.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventGeneratorType")
        .doc("Identifies the type of the System that generated the Event URL.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventTransactionId")
        .doc("Transaction identity.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventLocationType")
        .doc("""
            Identifies the type of System on which the Event occurred. In most cases this would be
            the Event Emitter, but in some cases the Emitter would not reflect where the Event
            actually occurred, For example, in the case of client-less apps, such as SamsungTV+,
            events such as clipStart, episodeStart that occur on the client would be fired by a
            back-end service such as stitcher. This field would help to correctly distinguish event
            emitter and event location in such situations.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventName")
        .doc("Identifies the Name of the Event being fired.")
        .type(EVENT_NAME_ENUM).noDefault()

        .name("eventEmitterIp")
        .doc("User IP address.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("eventOccurredTimestampUtc")
        .doc("""
            Identifies the timestamp in UTC (with millisecond precision) at which the Event occurred
            at the Client or Server. If the app decides to batch Events before emitting, this should
            reflect the time at which the Event occurred, NOT the time at which the Event was sent
            to the event collector (s.pluto.tv).""")
        .type(TIMESTAMP_MILLIS).noDefault()

        .name("eventEmittedUtc")
        .doc("Timestamp when event was sent by client device to collector.")
        .type(OPTIONAL_TIMESTAMP_MILLIS).withDefault(null)

        .name("eventServerLoggedUtc")
        .doc("Timestamp event began ETL.")
        .type(OPTIONAL_TIMESTAMP_MILLIS).withDefault(null)

        .name("eventEtlLoadUtc")
        .type(OPTIONAL_TIMESTAMP_MILLIS).withDefault(null)

        .name("context")
        .doc("""
            Field used for server-emitted Events when hitID is not feasible. This field is used in
            conjunction with parentContext to tie server-side Events together.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("environment")
        .doc("""
            Identifies whether the app generating the Event is in the Development Environment, Test
            Environment or Production Environment.""")
        .type(STRING).noDefault()

        .name("episodeId")
        .doc("Identifies the CMS Episode ID of the Episode being watched when the Event is fired.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("episodeTimelinePoint")
        .doc("""
            Identifies the point in the Episode (hh:mm:ss) at the time the Event is fired. This
            should be populated from the episode metadata.""")
        .type(OPTIONAL_LONG).withDefault(null)

        .name("userCountryCode")
        .doc("ISO 3166-1 code for the country the visitor is located in.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("userRegionCode")
        .doc("ISO-3166-2 code for country region the visitor is in.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("userRegion")
        .doc("Visitor region name.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("userCity")
        .doc("City the visitor is in.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("userLatitude")
        .doc("Visitor location latitude.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("userLongitude")
        .doc("Visitor location longitude.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("userTimeZone")
        .doc("Visitor timezone name.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("userPostalCode")
        .doc("Postcode the visitor is in.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("userInteractionMode")
        .doc("""
            Identifies how the User interacted with the app in that particular Event, using:
            Touch (almost all mobile devices and some Web)
            Mouse (most Web)
            Keyboard
            Controller (Roku, FireTV, Apple TV, PS4, etc.)
            Voice.
            Applies only to Interact category Events. Note that this is different from the
            "interactionLocation" specified in the "linkId" tabs.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("hitId")
        .doc("""
            Identifies the unique Hit ID within the current session the User is in when the Event
            is fired. The Hit ID is a strictly increasing sequence number that is incremented by one
            for every subsequent Event. For example, when the user opens the app, the Hit ID = 1.
            Whenever the app fires the next Event, the HitID for that Event = 2, etc.""")
        .type(INTEGER).noDefault()

        .name("autoPlay")
        .doc("""
            Indicates whether the Channel was automatically playing without the User actively
            selecting to play that specific Channel. This can happen when the User launches the app,
            when the User goes to another Section and comes back to Live, etc. If a channelRequest
            Event is fired without a preceding channelSelect Event (meaning a User did not actively
            select that Channel), then that channelRequest Event and all subsequent viewing Events
            for that Channel should have isAutoPlay = TRUE until the User actively changes the
            Channel.""")
        .type(OPTIONAL_BOOLEAN).withDefault(null)

        .name("itemPositionX")
        .doc("""
            Identifies the horizontal (x) component of the (x,y) positional coordinates of the
            applicable item (Channel or VOD title). Refer to the description of all applicable
            events for more details on the logic.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("itemPositionY")
        .doc("""
            Identifies the vertical (y) component of the (x,y) positional coordinates of the
            applicable item (Channel or VOD title). Refer to the description of all applicable
            events for more details on the logic.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("label")
        .doc("""
            This is a generic field that will be used to send string type information pertaining to
            a specific Event. This field was included for the cases where it doesn't make sense to
            create a totally new field.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("linkId")
        .doc("""
            Identifies the direct link of a User interaction point with the app (whether it is a
            through a click, remote controller, or touch screen). Each interaction point has a
            unique linkID. For example, the mute button on the app has been assigned its own unique
            linkID. This linkID will have to be passed as a parameter of the linkClick Event
            whenever a user clicks on the mute button.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("messageContent")
        .doc("""
            Identifies the information sent or received in a message such as Requests or Responses.
            At the time this documentation was written, this field applies to the following Events:
            cmPodRequestSent
            cmPodRequestReceived
            cmPodResponseReceived
            cmWrapperRequestSent
            cmWrapperResponseReceived
            cmPodRequestSent
            cmPodRequestReceived
            cmPodResponseReceived
            cmWrapperRequestSent
            cmWrapperResponseReceived.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("messageReceiverName")
        .doc("""
            Identifies the specific Entity receiving the message. Applies to Events that represent
            the sending of a message from one Entity to another, for example, adPodRequest sent from
            Stitcher to adProxy. This field is an additional level of detail to the
            "messageReceiverType" field and is used to distinguish between different entities within
            a particular type. For example, the messageReceiverType adserver could have the
            "messageReceiverName" freewheel or dfp of aqua.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("messageReceiverType")
        .doc("""
            Identifies the type of Entity receiving the message. Applies to Events that represent
            the sending of a message from one Entity to another, for example, adPodRequest sent from
            Stitcher to adProxy. In this case the messageReceiverType will be adProxy.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("messageSenderName")
        .doc("""
            Identifies the specific System sending the message. Applies to Events that represent the
            sending of a message from one System to another, for example, adPodRequest sent from
            Stitcher to adProxy. This field is an additional level of detail to the messageSenderType
            field and is used to distinguish between different Systems within a particular type.
            For example, the messageSenderType adserver could have the messageSenderName freewheel
            or dfp of aqua.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("messageSenderType")
        .doc("""
            Identifies the type of Entity sending the message. Applies to Events that represent the
            sending of a message from one Entity to another, for example, adPodRequest sent from
            Stitcher to adProxy. In this case the messageSenderType will be Stitcher.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("networkBandwidth")
        .doc("Identifies the bandwidth of the network in kbps.")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("networkUserId")
        .doc("""
            Unique identifier for a user, based on a cookie from the collector (so set at a network
            level and should not be set by a tracker).
            """)
        .type(OPTIONAL_STRING).withDefault(null)

        .name("pageName")
        .doc("""
            Identifies the Page (or Screen) the User is on when the Event is fired. Every Page
            (or Screen) should have a unique name. Please note: this pageName may not match what the
            technical team has named the page or screen within the app code. This is defined purely
            from an Analytics perspective in order to aid in the understanding of user behavior.
            This value should be a concatenation of Section and Section Page values with a | separating
            them. This info can be obtained from the linkID tabs. (e.g. if Section = mypluto and
            Section Page = home, then pageName = mypluto|home.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("pageUrlSp")
        .doc("Page URL (Snowplow value).")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("pageUrlHostSp")
        .doc("Host (domain), ex. www.google.com (Snowplow value).")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("pageUrlSchemeSp")
        .doc("Scheme (protocol), ex. http (Snowplow value).")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("pairingCode")
        .doc("""
            This is the activation/pairing code that is used for pairing two devices. This should be
            populated when the Events PairingSuccessSecondary, PairingSuccessPrimary,
            PairingCodeInvalid are fired. For all other Events populate 'na'.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("parentContext")
        .doc("""
            Field used for server-emitted Events when hitID is not feasible. This field is used in
            conjunction with Context to tie server-side Events together.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("pinnedCategoryIndex")
        .doc("""
            Identifies the location of a Pinned Category of the Channel/VOD title being watched or
            being clicked on. If the Channel/VOD title is not in a pinned category, pass 0 as the
            value. At the time this documentation was written, there was only one pinned category:
            Featured Channels.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("pinnedCategoryName")
        .doc("""
            Identifies the name of a Pinned Category of the Channel/VOD title being watched or being
            clicked on. If the Channel/VOD title is not in a pinned category, pass na as the value.
            At the time this documentation was written, there was only one pinned category:
            Featured Channels.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("pinnedItemIndex")
        .doc("""
            Identifies the location of a Pinned Item (an item is a Channel or a VOD title) being
            watched or being clicked on. If the Channel/VOD title is not in a pinned category,
            pass 0 as the value. Two important notes:
            1. If the User selects a Item (Channel or VOD title) from its natural position in the
            Program Guide or VOD section, even if the same Item is pinned on a Pinned Category that
            time, the pinnedItemIndex should still be set to 0.
            2. If a User accesses a Item through a Pinned Category and, while the User was still
            watching the Item, it was taken off the Pinned Category, Events should still send this
            field with the original pinnedItemIndex value (until the User stops watching this
            channel).""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("playbackState")
        .doc("""
            Identifies the state of the video playback:
            - If the User is in guide mode (i.e. video is playing adjacent to the guide), populate
            value with "guide".
            - If the User is in fullscreen mode (regardless of screen orientation), populate
            value with "fullscreen".
            - If the User is casting to another device (i.e. the User's current screen is simply a
            remote to control the video), populate value with "cast".
            - If the User is in PIP mode, populate value with "pip"
            - if the User is in guide-pip mode, populate "guide-pip".""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("playerName")
        .doc("Identifies the name of the video player being used by the app.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("playerVersion")
        .doc("Identifies the version of the video player being used by the app.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("playerHeight")
        .doc("Identifies the height of video player being used by the app.")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("playerWidth")
        .doc("Identifies the width of video player being used by the app.")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("plutoUid")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("previousChannelId")
        .doc("""
            Identifies the CMS Channel ID of the Channel watched by the User prior to watching the
            current Channel, if applicable. This should not be populated till the first
            channelChange in a session.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("previousPageName")
        .doc("""
            Identifies the Page (or Screen) the User was on before coming to the current section.
            This value should be a concatenation of Section and Section Page values with a | separating
            them. This info can be obtained from the linkID tabs. (e.g. if Section = mypluto and
            Section Page = home, then pageName = mypluto|home).""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("previousSection")
        .doc("Identifies the section the User was in before coming to the current section.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("profileId")
        .doc("""
            Identifies the User Profile on the device, such as Roku, AppleTV, etc. This feature does
            not exist today but the field is provisioned for future use.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("programTimelineId")
        .doc("""
            Identifies the CMS Timeline ID that represents the Channel and Episode playing at the
            time the Event is fired.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("referrer")
        .doc("""
            Identifies the entire address from where the User came to pluto.tv/watch (usually part
            of the http header).""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("screenOrientation")
        .doc("""
            Identifies the orientation that the Screen was in when the Event was fired (landscape
            vs portrait).""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("section")
        .doc("""
            Identifies whether the User is in the Live TV section, the VOD section, or the MyPluto
            section at the time the Event is fired.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("seriesId")
        .doc("""
            Contains the CMS series ID. Since this field is not available in the content metadata
            available in apps during content playback, this field will only be used for non-watch
            events such as likeSeries.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("sessionId")
        .doc("""
            Identifies the unique Session ID of the current session that the User is in when the
            Event is fired. A Session is defined as the period from the point the User opens the app
            (or the point the User restarts activity after a gap of 30+ continuous minutes), to the
            point when the User closes the app or is inactive for 30+ continuous minutes.""")
        .type(STRING).noDefault()

        .name("stitcherVersion")
        .doc("Identifies the version of Stitcher software.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("streamBitRate")
        .doc("""
            Identifies the bit rate at which the video in kbps is streaming at the time the Event is
            triggered.""")
        .type(OPTIONAL_INTEGER).withDefault(null)

        .name("streamResolution")
        .doc("Identifies the video resolution of the content stream.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("subtitleLanguage")
        .doc("Identifies the language of the selected subtitles/closed captions (CC) track.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("testGroupId")
        .doc("""
            This will be the unique identifier of the Test Group to which this User/Client belongs
            for the Test represented by Test1 field.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("testId")
        .doc("""
            This is the unique identifier of the Test being executed. The Id will be stored on the
            Data Warehouse and managed by the Analytics team. For example, in the Data Warehouse,
            the Web VOD landing page test has a unique identifier of 20. If the User/Client
            (for which the Event is being fired) is part of the Web VOD landing page test, then
            populate the Test1 field with 20.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("utmCampaign")
        .doc("""
            Identifies the specific campaign that is being run (same UTM Source can have multiple
            campaigns). This can be captured from the referer that redirected the traffic.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("utmContent")
        .doc("""
            Identifies what specifically was clicked to bring the user to the site, such as a banner
            ad or a text link. It is often used for A/B testing and content-targeted ads. For
            example red-button, green-button. This can be captured from the referer that redirected
            the traffic. If the app was launched via the device's native search page / app store
            (i.e. searchIntegrationLaunch is fired), this field should identify the content the
            User clicked on.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("utmMedium")
        .doc("""
            Identifies what type of link was used, such as cpc or email, social. This can be
            captured from the referer that redirected the traffic. If the app was launched via the
            device's native search page / app store (i.e. searchIntegrationLaunch is fired),
            this field should capture that as well.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("utmSource")
        .doc("""
            This is the domain of the originating traffic without the top level domain (.com, .org,
            etc.) extension, for example facebook (not facebook.com), reddit (not reddit.com).
            This can be captured from the referer that redirected the traffic.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("utmTerm")
        .doc("""
            Identifies specific search keywords that were used in campaign. This can be captured
            from the referer that redirected the traffic.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("spTracker")
        .doc("Snowplow Tracker type/version.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("spCollector")
        .doc("Snowplow Collector type/version.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("spEnricher")
        .doc("Snowplow Enricher type/version.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("enrichedValue")
        .type(OPTIONAL_FLOAT).withDefault(null)

        .name("volumeLevel")
        .doc("""
            Identifies the player volume level at the point the Event was fired. This should be on
            a 0 to 1 scale.""")
        .type(OPTIONAL_FLOAT).withDefault(null)

        .name("jsonExtensions")
        .doc("""
            This is a generic complex field (json object) that will contain sub elements that apply
            to certain Events. As those sub elements are defined, they will be added to this
            document. The main reason of having this field is to prevent frequent changes to the
            data pipeline when new data points have to be introduced. With this field, the data
            point will be defined as a logical sub element of this json field. The data pipeline,
            for the most part, will not have to be changed. The only change in the data pipeline
            will be at the point where the new elements will have to be parsed into snowflake tables.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("activeSimOperator")
        .doc("""
            This field will capture the operator name of the active sim card on the device streaming
            the Pluto app, and is only applicable to devices having sim cards. This may or may not
            be the internet service that is used to stream PlutoTV on the device at various points
            in time. For example a user may have ATT as the active sim card on their device but may
            be streaming Pluto at home using a cable internet service and using the ATT sim card
            data service to stream outside of their home. In both these cases the
            "activeSimCardOperator" field will be populated with att.""")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("castingExtensions")
        .doc("""
            Whenever there is any interaction between the cast sender and the receiver, fields
            castSenderAppID, castSenderAppName, castSenderClientID , castSenderSessionID and
            castReceiverOriginalSessionID have to be passed from the cast-sender to the cast
            receiver. These fields will be populated in the new json field: castingExtensions
            cast-sender will only send these fields (parameters) to the cast-receiver whenever
            there is a cast-related communication between them.
            """)
        .type(OPTIONAL_STRING).withDefault(null)

        .name("featureType")
        .doc("""
            This field will be populated for the pageView event to identify if a specific product
            feature was viewed. It will be emitted at the time of occurrence of the user 'viewing'
            the feature.
            """)
        .type(OPTIONAL_STRING).withDefault(null)

        .name("hostname")
        .doc("Name of the host which has sent HTTP request to the collector.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("httpPath")
        .doc("Path of HTTP request processed by collector.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("httpQueryString")
        .doc("Query string of HTTP request processed by collector.")
        .type(OPTIONAL_MAP_OF_STRING).withDefault(null)

        .name("httpEncoding")
        .doc("Encoding of HTTP request processed by collector.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("httpContentType")
        .doc("Content type of HTTP request processed by collector.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("httpHeaders")
        .doc("Headers of HTTP request processed by collector.")
        .type(OPTIONAL_MAP_OF_STRING).withDefault(null)

        .name("custom1")
        .doc("Custom field.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("custom2")
        .doc("Custom field.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("custom3")
        .doc("Custom field.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("refererSp")
        .doc("Identifies the referer coming from the apps. Either from webapp or from the trackers which ever is available. Pluto-event referer takes higher precedence.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("refrMedium")
        .doc("Identifies the Medium of the referer which is parsed from the pageReferer field. Unknown for when we know the source, but not the medium. email for webmail providers. social for social media services.search for search engines.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("refrSource")
        .doc("Identifies the source of the referer which is parsed from the pageReferer field. Identifies each known provider (aka source) by name, and then which domains each provider uses.")
        .type(OPTIONAL_STRING).withDefault(null)

        .name("refrTerm")
        .doc("Identifies the term of the referer which is parsed from the pageReferer field. Identifies the parameters used in the search engine URL to identify the search.")
        .type(OPTIONAL_STRING).withDefault(null)
        .endRecord();

    String outputFile = (args.length == 0 || args[0] == null || "".equals(args[0]))
        ? "src/main/resources/schemas/event-data-payload.avsc"
        : args[0];

    String content = eventSchema.toString(true);

    Files.writeString(Path.of(outputFile), content);
    System.out.println(content);
  }
}
