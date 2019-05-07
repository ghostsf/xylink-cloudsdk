package com.ananwulian.xylinkcloudsdk.model;


public class UserProfile {
	private static final long serialVersionUID = 8439938177052776177L;
	private long id;
	private String displayName;
	private String cellPhone;
	private String profilePicture;
	private boolean debug;
	private int type;
	private long requestTimestamp;
	private String userId;
	private String countryCode;
	private long userCreateTime;
	private String identityKey;
	private boolean hasObserverPermission;
	private String enterpriseId;
	private String email;
	private boolean validate;
	private long passwordExpireTime;
	private String departmentId;
	private String callNum;
	private String userFlag;

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPasswordExpireTime() {
		return passwordExpireTime;
	}

	public void setPasswordExpireTime(long passwordExpireTime) {
		this.passwordExpireTime = passwordExpireTime;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public long getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(long requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public long getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(long userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public String getIdentityKey() {
		return identityKey;
	}

	public void setIdentityKey(String identityKey) {
		this.identityKey = identityKey;
	}

	public boolean isHasObserverPermission() {
		return hasObserverPermission;
	}

	public void setHasObserverPermission(boolean hasObserverPermission) {
		this.hasObserverPermission = hasObserverPermission;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getCallNum() {
		return callNum;
	}

	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserProfile that = (UserProfile) o;

		return id == that.id;

	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}
}
