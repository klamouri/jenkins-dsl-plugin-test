job('example') {
    triggers {
        cron('* * * * * *')
    }
    steps {
        shell('echo START')
    }
}