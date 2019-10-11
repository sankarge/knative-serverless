# knative-serverless

https://knative.dev/docs/

https://knative.dev/docs/serving/samples/hello-world/helloworld-java-spring/index.html

## Local Setup with Minikube

### Access Kubernetes Dashboard UI

To access the UI, you have to perform the following steps (in the same folder):
- create the namespace `kubernetes-dashboard` ([how to](https://kubernetes.io/docs/tasks/administer-cluster/namespaces-walkthrough/#create-new-namespaces))
- create a user with permissions to log into the dashboard ([how to](https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md))
- deploy the dashboard UI ([how to](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/#deploying-the-dashboard-ui))
- access the dashboard ([how to](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/#accessing-the-dashboard-ui))

Run Kubernetes locally using Docker Desktop

### Run Knative

To run Knative locally on Minikube, perform the following steps:
- Run Kubernetes using docker desktop
- Install Knative on MiniKube ([how to, skip creating the Kubernetes Cluster](https://knative.dev/v0.3-docs/install/knative-with-minikube/))
