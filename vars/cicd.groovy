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
def e1 ()
{
  mail bcc: '', body: 'Jenkins is unable to download the code from github', cc: '', from: '', replyTo: '', subject: 'Continuous Download failed', to: 'santosh.adurthi@gmail.com'
  exit (1)
}
def e2 ()
{
   mail bcc: '', body: 'Jenkins is unable to build the .war file', cc: '', from: '', replyTo: '', subject: 'Continuous Build failed', to: 'sandy.kalwa@gmail.com'
   exit (1)
}
def e3 ()
{
  mail bcc: '', body: 'Jenkins is unable to deploy the .war file', cc: '', from: '', replyTo: '', subject: 'Continuous Deployment failed', to: 'sandy.kalwa@gmail.com'
  exit (1)
}
def e4 ()
{
  mail bcc: '', body: 'Jenkins is unable to run the selenium code', cc: '', from: '', replyTo: '', subject: 'Continuous Testing failed', to: 'adurthisravan@gmail.com'
  exit (1)
}
def e5 ()
{
  mail bcc: '', body: 'Jenkins is unable to deploy the prodapp.war', cc: '', from: '', replyTo: '', subject: 'Continuous Delivery failed', to: 'adurthisravan@gmail.com'
  exit (1)
}
