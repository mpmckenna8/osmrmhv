package de.cdauth.osm.lib;

/**
 * Represents the version of a {@link VersionedItem}. Versions start at 1 and are always increased by 1, gaps
 * do not exist. They are 64-bit integers.
 * 
 * @author cdauth
 */
public class Version implements Comparable<Version>
{
	private final Long m_version;

	/**
	 * Creates a version from a long.
	 * @param a_version The Version.
	 */
	public Version(Long a_version)
	{
		m_version = a_version;
	}
	
	/**
	 * Creates a Version from a String.
	 * @see {@link Long#Long(String)}
	 * @param a_id The Version, usually the value of the XML attribute <code>version</code>.
	 */
	public Version(String a_version)
	{
		m_version = new Long(a_version);
	}
	
	/**
	 * Returns the long representation of this version.
	 * @return The long representation of this version.
	 */
	public Long asLong()
	{
		return m_version;
	}
	
	@Override
	public int hashCode()
	{
		if(m_version == null)
			return 0;
		return m_version.hashCode();
	}
	
	@Override
	public boolean equals(java.lang.Object a_other)
	{
		if(!(a_other instanceof ID))
			return false;
		
		Version other = (Version) a_other;
		if(m_version == null && other.m_version == null)
			return true;
		else if(m_version != null && m_version.equals(other.m_version))
			return true;
		else
			return false;
	}
	
	@Override
	public int compareTo(Version a_other)
	{
		if(m_version == null && a_other.m_version == null)
			return 0;
		else if(m_version == null)
			return -1;
		else if(a_other.m_version == null)
			return 1;
		else
			return m_version.compareTo(a_other.m_version);
	}
	
	@Override
	public String toString()
	{
		if(m_version == null)
			return "";
		return m_version.toString();
	}
}