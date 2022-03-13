<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
<xsl:template match="/">
  <html>
  <body>
    <h2>Employees Data</h2>
    <table border="1">
    <tr bgcolor="#9acd32">
      <th align="left">Name</th>
      <th align="left">Mobile Phone</th>
      <th align="left">Home Phone</th>
            <th align="left">Work Phone</th>

      <th align="left">Address</th>
      <th align="left">Email</th>
    </tr>
    <xsl:for-each select="employees/employee">
    <tr>
      <td><xsl:value-of select="name"/></td>
      <td><xsl:value-of select="phones/phone[@type='mobile']"/></td>
      <td><xsl:value-of select="phones/phone[@type='home']"/></td>
      <td><xsl:value-of select="phones/phone[@type='work']"/></td>
      <td><xsl:value-of select="address"/></td>
      <td><xsl:value-of select="email"/></td>
    </tr>
    </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>
