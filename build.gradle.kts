import com.dropbox.affectedmoduledetector.AffectedModuleConfiguration

plugins {
    id("com.dropbox.affectedmoduledetector") version "0.3.1"
}

affectedModuleDetector {
    baseDir = "${project.rootDir}"
    pathsAffectingAllModules = setOf("gradle")
    logFilename = "output.log"
    logFolder = "${project.rootDir}/affectedModuleDetector"
    specifiedBranch = "main"
    compareFrom = "SpecifiedBranchCommitMergeBase" //default is PreviousCommit
    ignoredFiles = setOf(".*\\.md", ".*\\.txt", ".*README")
    includeUncommitted = true
    customTasks = setOf(
            AffectedModuleConfiguration.CustomTask("printProjectsImpacted", "printProjectName", "print name")
    )
}

// Register Custom Task with root project
tasks.register<AffectedTask>("affected") {
    group = "Affected Module Detector"
    description = "print all affected subprojects due to code changes"
}

// Define Custom Task
open class AffectedTask : DefaultTask() {
    @TaskAction
    fun printAffected() {
        project.subprojects.forEach {
            println("Is ${it.name} Affected? : " + com.dropbox.affectedmoduledetector.AffectedModuleDetector.isProjectAffected(it))
        }
    }
}