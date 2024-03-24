def gitdownload (repo)
{
  https://github.com/SantoshAdurthi/${repo}.git
}
def mavenbuild ()
{
  sh 'mvn package'
}
def tomcatdeploy (jobname,private_ip_address,context)
{
  sh 'scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ${username}@${private_ip_address}:/var/lib/tomcat9/${context}.war'
}
def testing (jobname)
{
  sh 'java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar'
}
