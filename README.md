# knative-serverless

https://knative.dev/docs/

https://knative.dev/docs/serving/samples/hello-world/helloworld-java-spring/index.html

## Local Setup with Minikube

https://docs.docker.com/docker-for-mac/install/

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

### Build Docker images

https://github.com/GoogleContainerTools/jib

./mvnw compile jib:dockerBuild -Dimage=knative-1

#### Knative & Istio pods

```shell
w0byy:knative-serverless sankarganesh.eswaran$ kubectl get ns
NAME                 STATUS   AGE
default              Active   24d
docker               Active   24d
istio-system         Active   16m
knative-eventing     Active   102s
knative-monitoring   Active   101s
knative-serving      Active   103s
kube-node-lease      Active   24d
kube-public          Active   24d
kube-system          Active   24d

w0byy:knative-serverless sankarganesh.eswaran$ kubectl get all
NAME                 TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)   AGE
service/kubernetes   ClusterIP   10.96.0.1    <none>        443/TCP   24d

w0byy:knative-serverless sankarganesh.eswaran$    kubectl get pods --namespace knative-serving
NAME                                READY   STATUS    RESTARTS   AGE
activator-68d9f95cd-594p9           1/1     Running   0          34s
autoscaler-5655c9fcfd-fln85         1/1     Running   0          34s
autoscaler-hpa-8668fc6f68-c574w     1/1     Running   0          34s
controller-5b77c5596c-wx5sl         1/1     Running   0          33s
networking-istio-6d7d44d879-ngg4h   1/1     Running   0          33s
webhook-75b4fc9999-fwlvx            1/1     Running   0          33s

w0byy:knative-serverless sankarganesh.eswaran$    kubectl get pods --namespace knative-eventing
NAME                                  READY   STATUS    RESTARTS   AGE
eventing-controller-db9b58855-ltn89   1/1     Running   0          42s
eventing-webhook-595c6b4fd8-v4f2v     1/1     Running   0          42s
imc-controller-7b9b7f9f66-dm44l       1/1     Running   0          42s
imc-dispatcher-775c96b5b5-j7hj5       1/1     Running   0          42s
sources-controller-78655cd9f9-tvzbd   1/1     Running   0          42s

w0byy:knative-serverless sankarganesh.eswaran$    kubectl get pods --namespace knative-monitoring
NAME                                  READY   STATUS    RESTARTS   AGE
elasticsearch-logging-0               1/1     Running   0          6m42s
elasticsearch-logging-1               1/1     Running   0          4m35s
grafana-85c86fb7b9-9s8sp              1/1     Running   0          6m41s
kibana-logging-7cb6b64bff-b8p5f       1/1     Running   0          6m42s
kube-state-metrics-75fdd67ffc-8qcjk   4/4     Running   0          4m29s
node-exporter-455zs                   2/2     Running   0          6m42s
prometheus-system-0                   1/1     Running   0          6m41s
prometheus-system-1                   1/1     Running   0          6m41s

w0byy:knative-serverless sankarganesh.eswaran$ kubectl get pods --namespace istio-system
NAME                                    READY   STATUS    RESTARTS   AGE
istio-ingressgateway-57dfd8fd67-lgj56   1/1     Running   0          3m50s
istio-pilot-6fb7569c86-f485c            1/1     Running   0          3m50s
zipkin-cbb659848-2n8sc                  1/1     Running   0          2m2s
```