job('example') {
    triggers {
        cron('*/2 * * * *')
    }
    steps {
        shell('echo START')
    }
}


job('example-6') {
    triggers {
        cron('*/3 * * * *')
    }
    steps {
        shell('echo START 2')
    }
}

job('example-email') {
    publishers {
        extendedEmail {
            recipientList('me@halfempty.org')
            defaultSubject('Oops')
            defaultContent('Something broken')
            contentType('text/html')
            triggers {
                failure()
            }
        }
    }
}

job('example-email-sec') {
    steps {
        shell('exit 2')
    }
    publishers {
        extendedEmail {
            recipientList('karim@gumgum.com')
            contentType('text/html')
            triggers {
                failure()
                fixed()
            }
        }
    }
    configure { project ->
        def failureTriggerNode = project / publishers / 'hudson.plugins.emailext.ExtendedEmailPublisher' / 'configuredTriggers' / 'hudson.plugins.emailext.plugins.trigger.FailureTrigger'
        failureTriggerNode << requiredFailureCount (5)
        failureTriggerNode.name = 'hudson.plugins.emailext.plugins.trigger.XNthFailureTrigger'
    }
}