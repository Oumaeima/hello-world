pipeline{
      agent any
  

      stages{
             stage('Checkout'){
                   steps{
                        echo "KOU Checkout"
                       // git 'https://github.com/khalidOubelque/hello-world.git'
                   }               
             }
       
            
            stage('Build'){
                  steps{
                     echo "KOU Maven Build"
                     sh "${mvnHome}/bin/mvn clean package -Dmaven.test.skip=true"
                  }
            }
            
             stage ('Test-JUnit'){
                   steps{
                     echo "KOU UT"
                   "'${mvnHome}/bin/mvn' test surefire-report:report"
                   }
            }
            
            stage('Deploy') { 
                  steps{
                        echo "KOU Deploy"
                       
                  }
            }
            
            
      } 
    
 }
      

