package com.ananwulian.xylinkcloudsdk.model.callback;

/**
 * Created by wenya on 16/4/9.
 */
public enum CallbackEvent {
    // 入会/出会（企业级别回调）
    NewUserCall,
    // 直播状态变更回调（企业级别回调）
    LiveStatus,
    // 云会议室参会人状态（云会议室级别回调）
    ConferenceRosterInfo,
    // 视频录制结束（企业级别回调）
    RecordingStop,
    // 开启录制状态反馈（如需要知道某个开启录制的动作是否成功）（企业级别回调）
    RecordStatus,
    // 转码状态反馈（企业级别回调）
    TranscodingStatus,
    // 云会议室参会人举手动作（云会议室级别回调）
    NemoHands
}
