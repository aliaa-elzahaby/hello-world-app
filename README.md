# Infrastructure Deployment with Terraform

## Introduction

This documentation provides a comprehensive guide to deploying a basic AWS infrastructure using Terraform. This setup is designed for both technical and non-technical users who wish to automate the deployment of a web application infrastructure. The deployment includes an Amazon VPC, EC2 instances, RDS, S3 buckets, IAM roles, and other necessary resources.

## Overview

### Description

This Terraform configuration script automates the deployment of a basic Amazon Web Services (AWS) infrastructure to host a web application. It sets up essential components such as:

* **Amazon VPC** with subnets, route tables, and an Internet Gateway for networking.
* **Security Groups** for access control, allowing Web (HTTP) and SSH access.
* **Amazon EC2 Instance** with associated IAM roles for running the web application.
* **Amazon RDS Instance** for database services, secured with its own Security Group.
* **Amazon S3 Bucket** for data storage, with public access blocked and server-side encryption enabled.
* **IAM Policies and Roles** for managing permissions.

### Problem Solve

By deploying this infrastructure, it resolves the complexity of setting up a scalable and secure AWS environment manually. The configuration ensures that all resources are consistently deployed, reducing human error and increasing efficiency.

## Usage

You can use this Terraform code by cloning the repository, navigating to the directory containing the Terraform files, and executing the Terraform commands as demonstrated below.

**Example Usage:**

```bash
# Initialize the Terraform configuration
terraform init

# Review the plan
terraform plan

# Apply the changes to create specified resources
terraform apply
```

## Requirements

To use this Terraform script, you need the following:

* **Terraform** installed on your system.
* **AWS Account** with credentials configured in your environment.
* **Follow the [AWS best practices](https://aws.amazon.com/architecture/well-architected) for credentials and resource management**.

## Providers

| Name | Description                                              |
| ---- | -------------------------------------------------------- |
| aws  | The AWS provider is used to interact with AWS resources. |

## Resources

A summary of resources created by this configuration:

| Resource Type                    | Name                                        |
| -------------------------------- | ------------------------------------------- |
| `aws_s3_bucket`                  | webapp\_bucket                              |
| `aws_vpc`                        | webapp\_vpc                                 |
| `aws_security_group`             | ec2\_sg, rds\_sg, lambda\_sg                |
| `aws_subnet`                     | public\_subnet, private\_subnet             |
| `aws_internet_gateway`           | igw                                         |
| `aws_route_table`                | public\_route\_table, private\_route\_table |
| `aws_nat_gateway`                | nat\_gateway                                |
| `aws_db_instance`                | postgres                                    |
| `aws_iam_role`                   | ec2\_role                                   |
| `aws_iam_policy`                 | s3\_read\_policy                            |
| `aws_iam_role_policy_attachment` | s3\_read\_attachment                        |
| `aws_db_subnet_group`            | rds\_subnet\_group                          |

## Inputs and Variables

| Variable Name         | Description                         | Default Value          |
| --------------------- | ----------------------------------- | ---------------------- |
| `s3_bucket_name`      | Name of the S3 bucket               | webapp-data-bucket     |
| `vpc_cidr`            | CIDR block for the VPC              | 10.0.0.0/16            |
| `aws_region`          | AWS region to deploy resources      | us-east-1              |
| `tags`                | Tags to apply to resources          | {}                     |
| `public_subnet_cidr`  | CIDR block for the public subnet    | 10.0.1.0/24            |
| `private_subnet_cidr` | CIDR block for the private subnet   | 10.0.2.0/24            |
| `availability_zone`   | Availability Zone for the subnets   | us-east-1a             |
| `db_username`         | Username for the RDS instance       | dbadmin                |
| `db_password`         | Password for the RDS instance       | YourStrongPasswordHere |
| `ec2_instance_type`   | Instance type for the EC2 instance  | t2.micro               |
| `ec2_ami`             | AMI ID for the EC2 instance         | ami-0c55b159cbfafe1f0  |
| `db_instance_class`   | Instance class for the RDS instance | db.t3.micro            |

## Getting Started

1. **Install Terraform:** Follow the instructions at [terraform.io](https://www.terraform.io/downloads.html).
2. **AWS Credentials:** Ensure your AWS CLI is configured with appropriate credentials.
3. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```
4. **Run Terraform commands:** Initialize, plan, and apply using Terraform CLI as mentioned in the Usage section.

## Important Notes & Warnings

* **Sensitive Information:** Ensure that sensitive information such as `db_password` is securely managed, potentially using AWS Secrets Manager in production.
* **Cost:** Be aware of AWS costs associated with running resources; terminate the environment if not in use.
* **Security:** Consider customizing security groups and IAM policies to better fit your security requirements.

Exercise 2: 
# Hello World Java App with Jenkins CI/CD Pipeline

This is a simple Java Maven app with a Jenkins pipeline to build, test and deploy.

## How to build locally

```bash
mvn clean package
java -jar target/hello-world-app-1.0-SNAPSHOT.jar
